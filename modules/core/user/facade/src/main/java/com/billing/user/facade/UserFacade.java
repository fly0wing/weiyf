package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.UserSession;
import com.billing.internalcontract.user.ActionTokenReq;
import com.billing.internalcontract.user.IUserFacade;
import com.billing.internalcontract.user.LoginReq;
import com.billing.internalcontract.user.RegisterReq;
import com.billing.user.orm.dao.CustomerLoginDao;
import com.billing.user.orm.dao.CustomerTerminalDao;
import com.billing.user.orm.model.CustomerLogin;
import com.billing.user.orm.model.CustomerTerminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zkai on 2014/8/26.
 */
@Service
public class UserFacade implements IUserFacade {
    @Autowired
    private CustomerLoginDao loginDao;
    @Autowired
    private CustomerTerminalDao terminalDao;
    @Autowired
    private CustomerLoginDao customerLoginDao;

    //成功
    private final static int SUCCESS = 0;
    //用户不存在
    private final static int USER_NOT_EXISTS = 1;
    //客户端不存在
    private final static int TERM_NOT_EXISTS = 2;
    //密码错误
    private final static int PASS_WRONG = 3;
    //令牌错误
    private final static int TOKEN_WRONG = 4;
    //注册失败
    private final static int REG_FAILED = 5;
    //用户名已注册
    private final static int USER_ALREADY_EXISTS = 6;
    //Email已注册
    private final static int EMAIL_ALREADY_EXISTS = 7;
    //电话号码已注册
    private final static int PHONE_ALREADY_EXISTS = 8;
    //密码更新失败
    private final static int PASS_UPD_FAILED = 9;

    //安全级别：匿名
    private final static int REG_ANONYMOUS = 0;
    //安全级别：用户名绑定
    private final static int REG_LOGIN_NAME = 1;
    //安全级别：Email绑定
    private final static int REG_EMAIL = 2;
    //安全级别：电话号码绑定
    private final static int REG_PHONE = 4;

    /**
     * 用户注册，如果该终端上已经存在匿名注册的用户，直接绑定到该匿名用户上。
     * @param registerReq
     * @return
     */
    @Override
    public BaseResp register(RegisterReq registerReq) {
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin = new CustomerLogin();
        boolean bAnonymousFlg = false;
        switch (registerReq.getLoginAccountType()) {
            case Anonymous:
                //TODO:Anonymous ID
                customerLogin = loginDao.getByLoginName(registerReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(false, USER_ALREADY_EXISTS, "匿名用户已注册");
                }
                customerLogin.setEnabled(true);
                customerLogin.setIsAnonymous(true);
                customerLogin.setLoginName(registerReq.getLoginAccount());
                customerLogin.setRequirePasswordChange(true);
                customerLogin.setSecurityLevel(REG_ANONYMOUS);
            case LoginName:
                customerLogin = loginDao.getByLoginName(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, USER_ALREADY_EXISTS, "用户名已注册");
                }
                if (SUCCESS == chkToken(customerLogin.getId(), registerReq.getSession().getTerminalId(), registerReq.getSession())) {
                    bAnonymousFlg = true;
                    customerLogin.setLoginName(registerReq.getLoginAccount());
                    customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + REG_LOGIN_NAME);
                } else {
                    customerLogin.setEnabled(true);
                    customerLogin.setIsAnonymous(false);
                    customerLogin.setLoginName(registerReq.getLoginAccount());
                    customerLogin.setCurrentPassword(registerReq.getPassword());
                    customerLogin.setRequirePasswordChange(false);
                    customerLogin.setSecurityLevel(REG_LOGIN_NAME);
                }
                break;
            case LoginEmail:
                customerLogin = loginDao.getByLoginEmail(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, EMAIL_ALREADY_EXISTS, "Email已注册");
                }
                if (SUCCESS == chkToken(customerLogin.getId(), registerReq.getSession().getTerminalId(), registerReq.getSession())) {
                    bAnonymousFlg = true;
                    customerLogin.setLoginEmail(registerReq.getLoginAccount());
                    customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + REG_EMAIL);
                } else {
                    customerLogin.setEnabled(true);
                    customerLogin.setIsAnonymous(false);
                    customerLogin.setLoginEmail(registerReq.getLoginAccount());
                    customerLogin.setCurrentPassword(registerReq.getPassword());
                    customerLogin.setRequirePasswordChange(false);
                    customerLogin.setSecurityLevel(REG_EMAIL);
                }
                break;
            case LoginPhone:
                customerLogin = loginDao.getByLoginPhone(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, PHONE_ALREADY_EXISTS, "电话号码已注册");
                }
                if (SUCCESS == chkToken(customerLogin.getId(), registerReq.getSession().getTerminalId(), registerReq.getSession())) {
                    bAnonymousFlg = true;
                    customerLogin.setLoginPhone(registerReq.getLoginAccount());
                    customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + REG_PHONE);
                } else {
                    customerLogin.setEnabled(true);
                    customerLogin.setIsAnonymous(false);
                    customerLogin.setLoginPhone(registerReq.getLoginAccount());
                    customerLogin.setCurrentPassword(registerReq.getPassword());
                    customerLogin.setRequirePasswordChange(false);
                    customerLogin.setSecurityLevel(REG_PHONE);
                }
                break;
        }
        if (bAnonymousFlg) {
            customerLogin.setIsAnonymous(false);
            customerLogin.setCurrentPassword(registerReq.getPassword());
            customerLogin.setRequirePasswordChange(false);
            customerLogin.setNickname("");
            customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            if(customerLoginDao.update(customerLogin)){
                baseResp = new BaseResp(true, SUCCESS, "");
            }else{
                baseResp = new BaseResp(true, REG_FAILED, "注册失败");
            }
        } else {
            //TODO:SessionId
            customerLogin.setFirstSessionId(1L);
//                customerLogin.setId(Session.getId());
            customerLogin.setNickname("");
            customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            if (customerLoginDao.save(customerLogin)) {
                baseResp = new BaseResp(true, SUCCESS, "");
            } else {
                baseResp = new BaseResp(true, REG_FAILED, "注册失败");
            }
        }
        return baseResp;
    }
    /**
     * 用户登录，确定会话中的用户标识
     * @param loginReq
     * @return
     */
    @Override
    public BaseResp login(LoginReq loginReq) {
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin = null;
        String sCurrentPass = "";
        Map<String, Object> params = new HashMap<>();
        switch (loginReq.getLoginAccountType()) {
            case Anonymous:
                //TODO:Anonymous ID
                customerLogin = loginDao.getByLoginName(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
                }
                break;
            case LoginName:
                customerLogin = loginDao.getByLoginName(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            case LoginEmail:
                customerLogin = loginDao.getByLoginEmail(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(false, TERM_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            case LoginPhone:
                customerLogin = loginDao.getByLoginPhone(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    baseResp = new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
        }
        if (loginReq.isAuto()) {
            int iRet = chkToken(customerLogin.getId(), loginReq.getSession().getTerminalId(), loginReq.getSession());
            if (SUCCESS == iRet) {
                baseResp = new BaseResp(true, SUCCESS, "");
            } else if (TOKEN_WRONG == iRet) {
                baseResp = new BaseResp(true, TOKEN_WRONG, "客户端令牌错误");
            } else if (TERM_NOT_EXISTS == iRet) {
                baseResp = new BaseResp(true, TERM_NOT_EXISTS, "客户端不存在");
            }
        } else {
            if (loginReq.getPassword().equals(sCurrentPass)) {
                baseResp = new BaseResp(true, SUCCESS, "");
            } else {
                baseResp = new BaseResp(false, PASS_WRONG, "密码错误");
            }
        }
        return baseResp;
    }

    /**
     * 验证终端Token
     * @param lCustomerId
     * @param lTermId
     * @param session
     * @return
     */
    private int chkToken(Long lCustomerId, Long lTermId, UserSession session) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", lCustomerId);
        params.put("terminalId", lTermId);
        List<CustomerTerminal> lstTerm = terminalDao.search(params);
        if (lstTerm.size() > 0) {
            if (lstTerm.get(0).getLastLoginToken().equals(session.getSessionToken())) {
                return SUCCESS;
            } else {
                return TOKEN_WRONG;
            }
        } else {
            return TERM_NOT_EXISTS;
        }
    }

    /**
     * 用户登出，主动结束会话，会话从内存及缓存中移除。
     * @param baseReq
     * @return void
     */
    @Override
    public void loginout(BaseReq baseReq) {
        //TODO:
        //session.delete(baseReq.getSession().getSessionId());
    }

    /**
     * 绑定手机号，在绑定前需要调用requestActionToken方法，传入待绑定的手机号，请求发送actionToken；
     * 在用户输入收到的actionToken后，再调用本方法传入用户输入的actionToken，以及请求actionToken时的reuestGuid:atRequestGuid。
     * @param baseReq
     * @return
     */
    @Override
    public BaseResp bindPhone(BaseReq baseReq) {

        return null;
    }

    /**
     * 修改密码:stringReq传入老的密码，stringReq2传入新的密码
     * @param baseReq
     * @return
     */
    @Override
    public BaseResp changePassword(BaseReq baseReq) {
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin = customerLoginDao.get(baseReq.getSession().getCustomerId());
        if(null == customerLogin){
            baseResp = new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
        } else if(!baseReq.getStringReq().equals(customerLogin.getCurrentPassword())){
            baseResp = new BaseResp(false, PASS_WRONG, "现密码错误");
        } else {
            customerLogin.setCurrentPassword(baseReq.getStringReq2());
            if (customerLoginDao.update(customerLogin)) {
                baseResp = new BaseResp(true, SUCCESS, "");
            } else {
                baseResp = new BaseResp(true, PASS_UPD_FAILED, "密码更新失败");
            }
        }
        return baseResp;
    }

    /**
     * 检查登录名(stringReq:用户LoginName)
     * @param baseReq
     * @return
     */
    @Override
    public BaseResp checkLoginName(BaseReq baseReq) {
        CustomerLogin customerLogin = null;
        customerLogin = loginDao.getByLoginName(baseReq.getStringReq());
        if (null == customerLogin) {
            return new BaseResp(true, USER_NOT_EXISTS, "用户不存在");
        }else {
            return new BaseResp(true, USER_ALREADY_EXISTS, "用户名已注册");
        }
    }

    /**
     * 检查登录电话号码(longReq:电话号码)
     * @param baseReq
     * @return
     */
    @Override
    public BaseResp checkLoginPhone(BaseReq baseReq) {
        CustomerLogin customerLogin = null;
        customerLogin = loginDao.getByLoginPhone(String.valueOf(baseReq.getLongReq()));
        if (null == customerLogin) {
            return new BaseResp(true, USER_NOT_EXISTS, "用户不存在");
        }else {
            return new BaseResp(true, PHONE_ALREADY_EXISTS, "电话号码已注册");
        }
    }

    @Override
    public BaseResp requestActionToken(ActionTokenReq actionTokenReq) {
        return null;
    }

    @Override
    public BaseResp authActionToken(BaseReq baseReq) {
        return null;
    }
}
