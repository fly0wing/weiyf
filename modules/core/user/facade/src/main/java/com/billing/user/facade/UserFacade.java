package com.billing.user.facade;

import com.billing.internalcontract.ActionTokenEnum;
import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.UserSession;
import com.billing.internalcontract.user.*;
import com.billing.user.facade.shiro.WyfSecurityUtils;
import com.billing.user.orm.business_model.TerminalInfo;
import com.billing.user.orm.dao.CustomerLoginDao;
import com.billing.user.orm.dao.CustomerTerminalDao;
import com.billing.user.orm.model.CustomerLogin;
import com.billing.user.orm.model.CustomerTerminal;
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
    private

    IUserTerminalFacade userTermFacade = new UserTerminalFacade();

    // Session
    UserSession userSession = null;

    //TODO: Dummy token服务
    Map<String,Object[]> mToken = new HashMap<>();
    /**
     * 用户注册，如果该终端上已经存在匿名注册的用户，直接绑定到该匿名用户上。
     *
     * @param registerReq 注册请求
     * @return 基本应答
     */
    @Override
    public BaseResp register(RegisterReq registerReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        BaseResp baseResp;
        CustomerLogin customerLogin = new CustomerLogin();
        boolean bAnonymousFlg = false;
        /** SESSION检查 */
        if (null == userSession) {
            return new BaseResp(true, UserConst.SESSION_ERROR, "SESSION失效");
        }
        /** 输入参数检查(匿名模式除外） */
        if (LoginAccountEnum.Anonymous != registerReq.getLoginAccountType() &&
                StringUtils.isBlank(registerReq.getLoginAccount())) {
            return new BaseResp(true, UserConst.PARAM_ERROR, "输入参数错误");
        }
        /** 通过Session终端指纹获取TermnialId */
        registerReq.setStringReq(userSession.getFingerprint());
        List<TerminalInfo> lstTermsInfo = userTermFacade.getTerminalByFingerprint(registerReq).getObjResult();
        Long lTermId  = lstTermsInfo.get(0).getTerminalId();
        switch (registerReq.getLoginAccountType()) {
            /** 匿名注册模式 */
            case Anonymous:
                //TODO:Anonymous ID
                customerLogin = loginDao.getByLoginName(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, UserConst.USER_ALREADY_EXISTS, "匿名用户已注册");
                }
                customerLogin = new CustomerLogin();
                customerLogin.setEnabled(true);
                customerLogin.setIsAnonymous(true);
                customerLogin.setLoginName(registerReq.getLoginAccount());
                customerLogin.setRequirePasswordChange(true);
                customerLogin.setSecurityLevel(UserConst.REG_ANONYMOUS);
                /** 用户名注册模式 */
            case LoginName:
                customerLogin = loginDao.getByLoginName(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, UserConst.USER_ALREADY_EXISTS, "用户名已注册");
                }
                customerLogin = new CustomerLogin();
                if (UserConst.SUCCESS == chkToken(lTermId, userSession.getLoginToken())) {
                    bAnonymousFlg = true;
                    customerLogin.setLoginName(registerReq.getLoginAccount());
                    customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + UserConst.REG_LOGIN_NAME);
                } else {
                    customerLogin.setEnabled(true);
                    customerLogin.setIsAnonymous(false);
                    customerLogin.setLoginName(registerReq.getLoginAccount());
                    customerLogin.setCurrentPassword(registerReq.getPassword());
                    customerLogin.setRequirePasswordChange(false);
                    customerLogin.setSecurityLevel(UserConst.REG_LOGIN_NAME);
                }
                break;
            /** Email注册模式 */
            case LoginEmail:
                customerLogin = loginDao.getByLoginEmail(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, UserConst.EMAIL_ALREADY_EXISTS, "Email已注册");
                }
                customerLogin = new CustomerLogin();
                if (UserConst.SUCCESS == chkToken(lTermId, userSession.getLoginToken())) {
                    bAnonymousFlg = true;
                    customerLogin.setLoginEmail(registerReq.getLoginAccount());
                    customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + UserConst.REG_EMAIL);
                } else {
                    customerLogin.setEnabled(true);
                    customerLogin.setIsAnonymous(false);
                    customerLogin.setLoginEmail(registerReq.getLoginAccount());
                    customerLogin.setCurrentPassword(registerReq.getPassword());
                    customerLogin.setRequirePasswordChange(false);
                    customerLogin.setSecurityLevel(UserConst.REG_EMAIL);
                }
                break;
            /** 电话注册模式 */
            case LoginPhone:
                customerLogin = loginDao.getByLoginPhone(registerReq.getLoginAccount());
                if (null != customerLogin) {
                    return new BaseResp(true, UserConst.PHONE_ALREADY_EXISTS, "电话号码已注册");
                }
                customerLogin = new CustomerLogin();
                if (UserConst.SUCCESS == chkToken(lTermId, userSession.getLoginToken())) {
                    bAnonymousFlg = true;
                    customerLogin.setLoginPhone(registerReq.getLoginAccount());
                    customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + UserConst.REG_PHONE);
                } else {
                    customerLogin.setEnabled(true);
                    customerLogin.setIsAnonymous(false);
                    customerLogin.setLoginPhone(registerReq.getLoginAccount());
                    customerLogin.setCurrentPassword(registerReq.getPassword());
                    customerLogin.setRequirePasswordChange(false);
                    customerLogin.setSecurityLevel(UserConst.REG_PHONE);
                }
                break;
        }
        /** 客户端存在匿名用户，绑定匿名用户 */
        if (bAnonymousFlg) {
            customerLogin.setIsAnonymous(false);
            customerLogin.setCurrentPassword(registerReq.getPassword());
            customerLogin.setRequirePasswordChange(false);
            customerLogin.setNickname("");
            customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            if (customerLoginDao.update(customerLogin)) {
                baseResp = new BaseResp(true, UserConst.SUCCESS);
            } else {
                baseResp = new BaseResp(true, UserConst.REG_FAILED, "注册失败");
            }
        } else {
            /** 客户端无匿名用户 */
            customerLogin.setFirstSessionId(userSession.getSessionId());
            customerLogin.setNickname("");
            customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            if (customerLoginDao.save(customerLogin)) {
                baseResp = new BaseResp(true, UserConst.SUCCESS);
            } else {
                baseResp = new BaseResp(true, UserConst.REG_FAILED, "注册失败");
            }
        }
        if (baseResp.isOK()) {
            // TODO:Token Generator

            /** 登录成功，检查更新终端绑定状态 */
            if(LoginAccountEnum.Anonymous != registerReq.getLoginAccountType()) {
                TerminalBindReq terminalBindReq = new TerminalBindReq();
                terminalBindReq.setAuto(true);
                terminalBindReq.setTerminalName("");
                baseResp = userTermFacade.bindTerminal(terminalBindReq);
            }else{
                TerminalBindReq terminalBindReq = new TerminalBindReq();
                terminalBindReq.setAuto(false);
                terminalBindReq.setTerminalName("");
                baseResp = userTermFacade.bindTerminal(terminalBindReq);
            }
        }
        return baseResp;
    }

    /**
     * 用户登录，确定会话中的用户标识
     *
     * @param loginReq 登录请求
     * @return 基本应答
     */
    @Override
    public BaseResp login(LoginReq loginReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        BaseResp baseResp = chkLoginUser(loginReq);
        if (baseResp.isOK()) {
            /** 登录成功，检查更新终端绑定状态 */
            TerminalBindReq terminalBindReq = new TerminalBindReq();
            terminalBindReq.setAuto(loginReq.isAuto());
            terminalBindReq.setTerminalName("");
            baseResp = userTermFacade.bindTerminal(terminalBindReq);
        }
        // TODO:Token Generator
        return baseResp;
    }

    /**
     * 登录用户情报检查
     *
     * @param loginReq 登录请求
     * @return 基本应答
     */
    public BaseResp chkLoginUser(LoginReq loginReq){
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin;
        String sCurrentPass = "";
        /** SESSION检查 */
        if (null == userSession) {
            return new BaseResp(true, UserConst.SESSION_ERROR, "SESSION失效");
        }
        /** 输入参数检查(匿名模式除外） */
        if (LoginAccountEnum.Anonymous != loginReq.getLoginAccountType() &&
                StringUtils.isBlank(loginReq.getLoginAccount())) {
            return new BaseResp(true, UserConst.PARAM_ERROR, "输入参数错误");
        }
        /** 通过Session终端指纹获取TermnialId */
        loginReq.setStringReq(userSession.getFingerprint());
        List<TerminalInfo> lstTermsInfo = userTermFacade.getTerminalByFingerprint(loginReq).getObjResult();
        Long lTermId  = lstTermsInfo.get(0).getTerminalId();
        switch (loginReq.getLoginAccountType()) {
            case Anonymous:
                //TODO:Anonymous Login
                if (UserConst.SUCCESS != chkToken(lTermId, userSession.getLoginToken())) {
                    return new BaseResp(true, UserConst.USER_NOT_EXISTS, "用户不存在");
                }
                break;
            /** 用户名LOGIN 模式 */
            case LoginName:
                customerLogin = loginDao.getByLoginName(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(true, UserConst.USER_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            /** Email LOGIN模式 */
            case LoginEmail:
                customerLogin = loginDao.getByLoginEmail(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(true, UserConst.TERM_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            /** 电话LOGIN模式 */
            case LoginPhone:
                customerLogin = loginDao.getByLoginPhone(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(true, UserConst.USER_NOT_EXISTS, "用户不存在");
                } else if (!loginReq.isAuto()) {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
        }
        /** 自动登录模式，检查令牌*/
        if (loginReq.isAuto()) {
            int iRet = chkToken(lTermId, userSession.getLoginToken());
            if (UserConst.SUCCESS == iRet) {
                baseResp = new BaseResp(true, UserConst.SUCCESS);
            } else if (UserConst.TOKEN_WRONG == iRet) {
                baseResp = new BaseResp(true, UserConst.TOKEN_WRONG, "客户端令牌错误");
            } else if (UserConst.TERM_NOT_EXISTS == iRet) {
                baseResp = new BaseResp(true, UserConst.TERM_NOT_EXISTS, "客户端不存在");
            }
        } else {
            /** 非自动登录模式，检查密码*/
            if (loginReq.getPassword().equals(sCurrentPass)) {
                baseResp = new BaseResp(true, UserConst.SUCCESS);
            } else {
                baseResp = new BaseResp(false, UserConst.PASS_WRONG, "密码错误");
            }
        }
        return baseResp;
    }
    /**
     * 验证终端Token
     *
     * @param lTermId 终端ID
     * @param sToken 终端Token
     * @return Token验证结果
     */
    private int chkToken(Long lTermId, String sToken) {
        Map<String, Object> params = new HashMap<>();
        params.put(CustomerTerminal.FN_terminalId, lTermId);
        List<CustomerTerminal> lstTerm = customerTermDao.search(params);
        if (lstTerm.size() > 0) {
            if (lstTerm.get(0).getLastLoginToken().equals(sToken)) {
                return UserConst.SUCCESS;
            } else {
                return UserConst.TOKEN_WRONG;
            }
        } else {
            return UserConst.TERM_NOT_EXISTS;
        }
    }

    /**
     * 用户登出，主动结束会话，会话从内存及缓存中移除。
     *
     * @param baseReq 基本请求
     */
    @Override
    public void loginout(BaseReq baseReq) {
        //TODO:
        WyfSecurityUtils.getSubject().logout();
    }

    /**
     * 绑定手机号，在绑定前需要调用requestActionToken方法，传入待绑定的手机号，请求发送actionToken；
     * 在用户输入收到的actionToken后，再调用本方法传入用户输入的actionToken，以及请求actionToken时的reuestGuid:atRequestGuid。
     * stringReq传入电话号码
     *
     * @param baseReq 基本请求
     * @return 基本应答
     */
    @Override
    public BaseResp bindPhone(BaseReq baseReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        BaseResp baseResp;
        /** SESSION检查 */
        if (null == userSession) {
            return new BaseResp(true, UserConst.SESSION_ERROR, "SESSION失效");
        }
        if(StringUtils.isBlank(baseReq.getStringReq())){
            return new BaseResp(true, UserConst.PARAM_ERROR, "输入参数错误");
        }
        CustomerLogin customerLogin = customerLoginDao.get(userSession.getCustomerId());

        customerLogin.setLoginPhone(baseReq.getStringReq());
        if(0 < customerLogin.getLoginPhone().length()){
            customerLogin.setSecurityLevel(customerLogin.getSecurityLevel() + UserConst.REG_PHONE);
        }
        if (customerLoginDao.update(customerLogin)) {
            baseResp = new BaseResp(true, UserConst.SUCCESS);
        } else {
            baseResp = new BaseResp(true, UserConst.REG_FAILED, "注册失败");
        }
        return baseResp;
    }

    /**
     * 修改密码:stringReq传入老的密码，stringReq2传入新的密码
     *
     * @param baseReq 基本请求
     * @return 基本应答
     */
    @Override
    public BaseResp changePassword(BaseReq baseReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        BaseResp baseResp;
        CustomerLogin customerLogin = customerLoginDao.get(userSession.getCustomerId());
        /** SESSION检查 */
        if (null == userSession) {
            return new BaseResp(false, UserConst.SESSION_ERROR, "SESSION失效");
        }
        /** 输入参数检查(匿名模式除外） */
        if (StringUtils.isBlank(baseReq.getStringReq()) || StringUtils.isBlank(baseReq.getStringReq2())) {
            return new BaseResp(true, UserConst.PARAM_ERROR, "输入参数错误");
        }
        if (null == customerLogin) {
            baseResp = new BaseResp(false, UserConst.USER_NOT_EXISTS, "用户不存在");
        } else if (!baseReq.getStringReq().equals(customerLogin.getCurrentPassword())) {
            baseResp = new BaseResp(false, UserConst.PASS_WRONG, "现密码错误");
        } else {
            customerLogin.setCurrentPassword(baseReq.getStringReq2());
            if (customerLoginDao.update(customerLogin)) {
                baseResp = new BaseResp(true, UserConst.SUCCESS, "");
            } else {
                baseResp = new BaseResp(true, UserConst.PASS_UPD_FAILED, "密码更新失败");
            }
        }
        return baseResp;
    }

    /**
     * 检查登录名(stringReq:用户LoginName)
     *
     * @param baseReq 基本请求
     * @return 基本应答
     */
    @Override
    public BaseResp checkLoginName(BaseReq baseReq) {
        /** 输入参数检查(匿名模式除外） */
        if (StringUtils.isBlank(baseReq.getStringReq())) {
            return new BaseResp(true, UserConst.PARAM_ERROR, "输入参数错误");
        }
        CustomerLogin customerLogin = loginDao.getByLoginName(baseReq.getStringReq());
        if (null == customerLogin) {
            return new BaseResp(true, UserConst.USER_NOT_EXISTS, "用户不存在");
        } else {
            return new BaseResp(true, UserConst.USER_ALREADY_EXISTS, "用户名已注册");
        }
    }

    /**
     * 检查登录电话号码(longReq:电话号码)
     *
     * @param baseReq 基本请求
     * @return 基本应答
     */
    @Override
    public BaseResp checkLoginPhone(BaseReq baseReq) {
        CustomerLogin customerLogin = loginDao.getByLoginPhone(String.valueOf(baseReq.getLongReq()));
        if (null == customerLogin) {
            return new BaseResp(true, UserConst.USER_NOT_EXISTS, "用户不存在");
        } else {
            return new BaseResp(true, UserConst.PHONE_ALREADY_EXISTS, "电话号码已注册");
        }
    }

    /**
     * 请求操作口令，例如：绑定手机号时，需要请求发送验证短信。
     *
     * @param actionTokenReq 行动令牌请求
     * @return 基本应答
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
     * @return 基本应答
     */
    @Override
    public BaseResp authActionToken(BaseReq baseReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        /** SESSION检查 */
        if (null == userSession) {
            return new BaseResp(false, UserConst.SESSION_ERROR, "SESSION失效");
        }
        /** 输入参数检查(匿名模式除外） */
        if (StringUtils.isBlank(baseReq.getAtRequestGuid())) {
            return new BaseResp(true, UserConst.PARAM_ERROR, "输入参数错误");
        }
        Object[] oInfo = mToken.get(baseReq.getAtRequestGuid());
        if (baseReq.getActionToken().equals(String.valueOf(oInfo[1]))) {
            return new BaseResp(true, UserConst.SUCCESS);
        } else {
            return new BaseResp(true, UserConst.TOKEN_ERROR, "输入验证码错误");
        }
    }

    /**
     * 验证码生成。
     *
     * @param iLen 验证码长度
     * @return 验证码
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
                cRandomChar = (char) (UserConst.ZERO + iAscii);
            } else if (iAscii < 36) {
                /** 随机数为10-35时，生成小写字母 */
                cRandomChar = (char) (UserConst.A_LOWER + (iAscii - 10));
            } else {
                /** 随机数为36-61时，生成大写字母 */
                cRandomChar = (char) (UserConst.A_UPPER + (iAscii - 36));
            }
            sRtn += String.valueOf(cRandomChar);
        }
        return sRtn;
    }
}
