package com.billing.user.facade;

import com.billing.internalcontract.ActionTokenEnum;
import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.UserSession;
import com.billing.internalcontract.session.ISessionFacade;
import com.billing.internalcontract.user.*;
import com.billing.user.orm.dao.CustomerLoginDao;
import com.billing.user.orm.dao.CustomerTerminalDao;
import com.billing.user.orm.dao.TerminalDao;
import com.billing.user.orm.model.CustomerLogin;
import com.billing.user.orm.model.CustomerTerminal;
import com.billing.user.orm.model.Terminal;
import com.mchange.lang.LongUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 用户服务
 * Created by zkai on 2014/8/26.
 */
@Service
public class UserFacade implements IUserFacade {
    @Autowired
    private CustomerLoginDao loginDao;
    @Autowired
    private CustomerTerminalDao customerTermDao;
    @Autowired
    private CustomerLoginDao customerLoginDao;
    @Autowired
    private TerminalDao terminalDao;

    IUserTerminalFacade userTermFacade = new UserTerminalFacade();

    //TODO: Dummy token服务
    Map<String,Object[]> mToken = new HashMap<String, Object[]>();
    //TODO: Dummy sessionFacade
//    ISessionFacade sessionFacade = new SessionFacade();

    public final static int UNIT_USER_FACADE = 1000;
    //成功
    public final static int SUCCESS = UNIT_USER_FACADE + 0;
    //用户不存在
    public final static int USER_NOT_EXISTS = UNIT_USER_FACADE + 1;
    //客户端不存在
    public final static int TERM_NOT_EXISTS = UNIT_USER_FACADE + 2;
    //密码错误
    public final static int PASS_WRONG = UNIT_USER_FACADE + 3;
    //令牌错误
    public final static int TOKEN_WRONG = UNIT_USER_FACADE + 4;
    //注册失败
    public final static int REG_FAILED = UNIT_USER_FACADE + 5;
    //用户名已注册
    public final static int USER_ALREADY_EXISTS = UNIT_USER_FACADE + 6;
    //Email已注册
    public final static int EMAIL_ALREADY_EXISTS = UNIT_USER_FACADE + 7;
    //电话号码已注册
    public final static int PHONE_ALREADY_EXISTS = UNIT_USER_FACADE + 8;
    //密码更新失败
    public final static int PASS_UPD_FAILED = UNIT_USER_FACADE + 9;
    //输入验证码错误
    public final static int TOKEN_ERROR = UNIT_USER_FACADE + 10;
    //参数错误
    public final static int PARAM_ERROR = UNIT_USER_FACADE + 11;
    //SESSION失效
    public final static int SESSION_ERROR = UNIT_USER_FACADE + 12;

    //安全级别：匿名
    public final static int REG_ANONYMOUS = 0;
    //安全级别：用户名绑定
    public final static int REG_LOGIN_NAME = 1;
    //安全级别：Email绑定
    public final static int REG_EMAIL = 2;
    //安全级别：电话号码绑定
    public final static int REG_PHONE = 4;

    /**
     * 用户注册，如果该终端上已经存在匿名注册的用户，直接绑定到该匿名用户上。
     *
     * @param registerReq 注册请求
     * @return
     */
    @Override
    public BaseResp register(RegisterReq registerReq) {
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin = new CustomerLogin();
        boolean bAnonymousFlg = false;
        // SESSION检查
        if (null == registerReq.getSession()) {
            return new BaseResp(true, SESSION_ERROR, "SESSION失效");
        }
        // 输入参数检查(匿名模式除外）
        if (LoginAccountEnum.Anonymous != registerReq.getLoginAccountType() &&
                StringUtils.isBlank(registerReq.getLoginAccount())) {
            return new BaseResp(true, PARAM_ERROR, "输入参数错误");
        }
        switch (registerReq.getLoginAccountType()) {
            //匿名注册模式
            case Anonymous:
                //TODO:Anonymous ID
                customerLogin = loginDao.getByLoginName(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, USER_ALREADY_EXISTS, "匿名用户已注册");
                }
                customerLogin.setEnabled(true);
                customerLogin.setIsAnonymous(true);
                customerLogin.setLoginName(registerReq.getLoginAccount());
                customerLogin.setRequirePasswordChange(true);
                customerLogin.setSecurityLevel(REG_ANONYMOUS);
                //用户名注册模式
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
            // Email注册模式
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
            // 电话注册模式
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
        //客户端存在匿名用户，绑定匿名用户
        if (bAnonymousFlg) {
            customerLogin.setIsAnonymous(false);
            customerLogin.setCurrentPassword(registerReq.getPassword());
            customerLogin.setRequirePasswordChange(false);
            customerLogin.setNickname("");
            customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            if (customerLoginDao.update(customerLogin)) {
                baseResp = new BaseResp(true, SUCCESS);
            } else {
                baseResp = new BaseResp(true, REG_FAILED, "注册失败");
            }
        } else {
            //客户端无匿名用户
            //TODO:SessionId
            customerLogin.setFirstSessionId(1L);
//                customerLogin.setId(Session.getId());
            customerLogin.setNickname("");
            customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            if (customerLoginDao.save(customerLogin)) {
                baseResp = new BaseResp(true, SUCCESS);
            } else {
                baseResp = new BaseResp(true, REG_FAILED, "注册失败");
            }
        }
        if (baseResp.isOK()) {
            // TODO:Token Generator
            /** 登录成功，检查更新终端绑定状态 */
            if(LoginAccountEnum.Anonymous != registerReq.getLoginAccountType()) {
                updBindSts(registerReq, true);
            }else{
                updBindSts(registerReq, false);
            }
        }
        return baseResp;
    }

    /**
     * 用户登录，确定会话中的用户标识
     *
     * @param loginReq 登录请求
     * @return
     */
    @Override
    public BaseResp login(LoginReq loginReq) {
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin = null;
        String sCurrentPass = "";
        Map<String, Object> params = new HashMap<>();
        /** SESSION检查 */
        if (null == loginReq.getSession()) {
            return new BaseResp(true, SESSION_ERROR, "SESSION失效");
        }
        /** 输入参数检查(匿名模式除外） */
        if (LoginAccountEnum.Anonymous != loginReq.getLoginAccountType() &&
                StringUtils.isBlank(loginReq.getLoginAccount())) {
            return new BaseResp(true, PARAM_ERROR, "输入参数错误");
        }
        switch (loginReq.getLoginAccountType()) {
            case Anonymous:
                //TODO:Anonymous ID
                customerLogin = loginDao.getByLoginName(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(true, USER_NOT_EXISTS, "用户不存在");
                }
                break;
            /** 用户名LOGIN 模式 */
            case LoginName:
                customerLogin = loginDao.getByLoginName(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(true, USER_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            /** Email LOGIN模式 */
            case LoginEmail:
                customerLogin = loginDao.getByLoginEmail(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(true, TERM_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            /** 电话LOGIN模式 */
            case LoginPhone:
                customerLogin = loginDao.getByLoginPhone(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    baseResp = new BaseResp(true, USER_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
        }
        /** 自动登录模式，检查令牌*/
        if (loginReq.isAuto()) {
            int iRet = chkToken(customerLogin.getId(), loginReq.getSession().getTerminalId(), loginReq.getSession());
            if (SUCCESS == iRet) {
                baseResp = new BaseResp(true, SUCCESS);
            } else if (TOKEN_WRONG == iRet) {
                baseResp = new BaseResp(true, TOKEN_WRONG, "客户端令牌错误");
            } else if (TERM_NOT_EXISTS == iRet) {
                baseResp = new BaseResp(true, TERM_NOT_EXISTS, "客户端不存在");
            }
        } else {
            /** 非自动登录模式，检查密码*/
            if (loginReq.getPassword().equals(sCurrentPass)) {
                baseResp = new BaseResp(true, SUCCESS);
            } else {
                baseResp = new BaseResp(false, PASS_WRONG, "密码错误");
            }
        }
        if (baseResp.isOK()) {
            /** 登录成功，检查更新终端绑定状态 */
                updBindSts(loginReq, loginReq.isAuto());
        }
        // TODO:Token Generator
        return baseResp;
    }

    /**
     * 检查终端的绑定状态，绑定状态为解绑或从未绑定时，绑定终端
     *
     * @param baseReq  基本请求
     * @param bAuto 是否自动登录
     * @return
     */
    private void updBindSts(BaseReq baseReq, boolean bAuto) {

        /** 获取绑定终端列表 */
        List<Long> lstTermsId = (List<Long>) userTermFacade.getBoundTerminals(baseReq).getObjResult();
        boolean bFlg = false;
        for (Long lTermId : lstTermsId) {
            if (baseReq.getSession().getTerminalId() == lTermId) {
                bFlg = true;
                break;
            }
        }
        /** 未绑定终端*/
        if (!bFlg) {
            Map<String, Object> params = new HashMap<>();
            params.put("customerId", baseReq.getSession().getCustomerId());
            params.put("terminalId", baseReq.getSession().getTerminalId());
            List<CustomerTerminal> lstCustomerTerms = customerTermDao.search(params);
            /** 该终端从未绑定过*/
            if (0 == lstCustomerTerms.size()) {
                /** 获取默认终端名*/
                CustomerTerminal customerTerm = new CustomerTerminal();
                params.clear();
                params.put("fingerprint", baseReq.getSession().getFingerprint());
                List<Terminal> lstTerms = terminalDao.search(params);
                params.clear();
                if (0 == lstTerms.size()) {
                    params.put("terminalName", "");
                } else {
                    params.put("terminalName", lstTerms.get(0).getDefaultName());
                }
                params.put("customerId", baseReq.getSession().getCustomerId());
                params.put("terminalId", baseReq.getSession().getTerminalId());
                params.put("bindStatusId", true);
                params.put("currentOpTime", new Timestamp(System.currentTimeMillis()));
                params.put("lastOpTime", new Timestamp(System.currentTimeMillis()));
                params.put("firstBindTime", new Timestamp(System.currentTimeMillis()));
                params.put("isAutoLogin", bAuto);
                //TODO:lastLoginToken
                params.put("lastLoginToken", "");
                /** 插入用户终端信息*/
                customerTermDao.save(customerTerm);
            } else {
                /** 该终端为解绑状态 */
                CustomerTerminal updCustomerTerm = lstCustomerTerms.get(0);
                updCustomerTerm.setBindStatus(true);
                /** 更新用户终端绑定状态 */
                customerTermDao.update(updCustomerTerm);
            }
        }
    }

    /**
     * 验证终端Token
     *
     * @param lCustomerId 客户ID
     * @param lTermId 终端ID
     * @param session Session
     * @return
     */
    private int chkToken(Long lCustomerId, Long lTermId, UserSession session) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", lCustomerId);
        params.put("terminalId", lTermId);
        List<CustomerTerminal> lstTerm = customerTermDao.search(params);
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
     *
     * @param baseReq 基本请求
     * @return
     */
    @Override
    public void loginout(BaseReq baseReq) {
        //TODO:
        //sessionFacade.stopSession(baseReq);
    }

    /**
     * 绑定手机号，在绑定前需要调用requestActionToken方法，传入待绑定的手机号，请求发送actionToken；
     * 在用户输入收到的actionToken后，再调用本方法传入用户输入的actionToken，以及请求actionToken时的reuestGuid:atRequestGuid。
     * stringReq传入电话号码
     *
     * @param baseReq 基本请求
     * @return
     */
    @Override
    public BaseResp bindPhone(BaseReq baseReq) {
        BaseResp baseResp = new BaseResp(false);
        /** SESSION检查 */
        if (null == baseReq.getSession()) {
            return new BaseResp(true, SESSION_ERROR, "SESSION失效");
        }
        if(StringUtils.isBlank(baseReq.getStringReq())){
            return new BaseResp(true, PARAM_ERROR, "输入参数错误");
        }
        CustomerLogin customerLogin = customerLoginDao.get(baseReq.getSession().getCustomerId());

        customerLogin.setLoginPhone(baseReq.getStringReq());
        if(0 < customerLogin.getLoginPhone().length()){
            customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + REG_PHONE);
        };
        if (customerLoginDao.update(customerLogin)) {
            baseResp = new BaseResp(true, SUCCESS);
        } else {
            baseResp = new BaseResp(true, REG_FAILED, "注册失败");
        }
        return baseResp;
    }

    /**
     * 修改密码:stringReq传入老的密码，stringReq2传入新的密码
     *
     * @param baseReq 基本请求
     * @return
     */
    @Override
    public BaseResp changePassword(BaseReq baseReq) {
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin = customerLoginDao.get(baseReq.getSession().getCustomerId());
        //SESSION检查
        if (null == baseReq.getSession()) {
            return new BaseResp(false, SESSION_ERROR, "SESSION失效");
        }
        //输入参数检查(匿名模式除外）
        if (StringUtils.isBlank(baseReq.getStringReq()) || StringUtils.isBlank(baseReq.getStringReq2())) {
            return new BaseResp(true, PARAM_ERROR, "输入参数错误");
        }
        if (null == customerLogin) {
            baseResp = new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
        } else if (!baseReq.getStringReq().equals(customerLogin.getCurrentPassword())) {
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
     *
     * @param baseReq 基本请求
     * @return
     */
    @Override
    public BaseResp checkLoginName(BaseReq baseReq) {
        CustomerLogin customerLogin = null;
        //输入参数检查(匿名模式除外）
        if (StringUtils.isBlank(baseReq.getStringReq())) {
            return new BaseResp(true, PARAM_ERROR, "输入参数错误");
        }
        customerLogin = loginDao.getByLoginName(baseReq.getStringReq());
        if (null == customerLogin) {
            return new BaseResp(true, USER_NOT_EXISTS, "用户不存在");
        } else {
            return new BaseResp(true, USER_ALREADY_EXISTS, "用户名已注册");
        }
    }

    /**
     * 检查登录电话号码(longReq:电话号码)
     *
     * @param baseReq 基本请求
     * @return
     */
    @Override
    public BaseResp checkLoginPhone(BaseReq baseReq) {
        CustomerLogin customerLogin = null;
        customerLogin = loginDao.getByLoginPhone(String.valueOf(baseReq.getLongReq()));
        if (null == customerLogin) {
            return new BaseResp(true, USER_NOT_EXISTS, "用户不存在");
        } else {
            return new BaseResp(true, PHONE_ALREADY_EXISTS, "电话号码已注册");
        }
    }

    /**
     * 请求操作口令，例如：绑定手机号时，需要请求发送验证短信。
     *
     * @param actionTokenReq 行动令牌请求
     * @return
     */
    @Override
    public BaseResp requestActionToken(ActionTokenReq actionTokenReq) {
        BaseResp baseResp = new BaseResp(true);
        if(ActionTokenEnum.Sms.equals(actionTokenReq.getActionTokenType())) {
            mToken.put(actionTokenReq.getRequestGuid(),new Object[]{actionTokenReq.getPhone(),makeActionToken(6)});
        }
        return baseResp;
    }

    /**
     * 验证操作口令。
     *
     * @param baseReq 基本请求
     * @return
     */
    @Override
    public BaseResp authActionToken(BaseReq baseReq) {
        //SESSION检查
        if (null == baseReq.getSession()) {
            return new BaseResp(false, SESSION_ERROR, "SESSION失效");
        }
        //输入参数检查(匿名模式除外）
        if (StringUtils.isBlank(baseReq.getAtRequestGuid())) {
            return new BaseResp(true, PARAM_ERROR, "输入参数错误");
        }
        Object[] oInfo = mToken.get(baseReq.getAtRequestGuid());
        if (baseReq.getActionToken().equals(String.valueOf(oInfo[1]))) {
            return new BaseResp(true, SUCCESS);
        } else {
            return new BaseResp(true, TOKEN_ERROR, "输入验证码错误");
        }
    }

    /**
     * 验证码生成。
     *
     * @param iLen 验证码长度
     * @return
     */
    private static String makeActionToken(int iLen) {
        Random r = new Random();
        String sRtn = "";
        char cRandomChar;
        for (int i = 0; i < iLen; i++) {
            /** 生成0-61的随机数*/
            int iAscii = r.nextInt(62);
            if (iAscii < 10) {
                /** 随机数为0-9时，生成数字 */
                cRandomChar = (char) ('0' + iAscii);
            } else if (iAscii < 36) {
                /** 随机数为10-35时，生成小写字母 */
                cRandomChar = (char) ('a' + (iAscii - 10));
            } else {
                /** 随机数为36-61时，生成大写字母 */
                cRandomChar = (char) ('A' + (iAscii - 36));
            }
            sRtn += String.valueOf(cRandomChar);
        }
        return sRtn;
    }
}
