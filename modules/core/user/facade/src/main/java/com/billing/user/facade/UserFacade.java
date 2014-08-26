package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.user.*;
import com.billing.user.orm.dao.CustomerLoginDao;
import com.billing.user.orm.dao.CustomerTerminalDao;
import com.billing.user.orm.model.CustomerLogin;
import com.billing.user.orm.model.CustomerTerminal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zkai on 2014/8/26.
 */
public class UserFacade implements IUserFacade {
    @Autowired
    private CustomerLoginDao loginDao;
    @Autowired
    private CustomerTerminalDao terminalDao;
    @Autowired
    private CustomerLoginDao customerLoginDao;

    private final static int SUCCESS = 0;
    private final static int USER_NOT_EXISTS = 1;
    private final static int TERM_NOT_EXISTS = 2;
    private final static int PASS_WRONG = 3;
    private final static int TOKEN_WRONG = 4;

    @Override
    public BaseResp register(RegisterReq registerReq) {

        return null;
    }

    @Override
    public BaseResp login(LoginReq loginReq) {
        BaseResp baseResp = new BaseResp(false);
        CustomerLogin customerLogin = null;
        String sCurrentPass = "";
        HashMap<String, Object> params = new HashMap<>();
        switch (loginReq.getLoginAccountType()) {
            case Anonymous:
                //TODO:ID
                customerLogin = loginDao.get(Long.parseLong(loginReq.getLoginAccount()));
                if (null == customerLogin) {
                    return new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
                } else {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            case LoginName:
                customerLogin = loginDao.getByLoginName(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
                } else {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            case LoginEmail:
                customerLogin = loginDao.getByLoginEmail(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    return new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
                } else {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
            case LoginPhone:
                customerLogin = loginDao.getByLoginPhone(loginReq.getLoginAccount());
                if (null == customerLogin) {
                    baseResp = new BaseResp(false, USER_NOT_EXISTS, "用户不存在");
                }
                else {
                    sCurrentPass = customerLogin.getCurrentPassword();
                }
                break;
        }
        if (loginReq.isAuto()) {
            params.put("customerId", customerLogin.getId());
            params.put("terminalId", loginReq.getSession().getTerminalId());
            List<CustomerTerminal> lstTerm = terminalDao.search(params);
            if (lstTerm.size() > 0) {
                if (lstTerm.get(0).getLastLoginToken().equals(loginReq.getSession().getSessionToken())) {
                    baseResp = new BaseResp(true, SUCCESS, "");
                } else {
                    baseResp = new BaseResp(true, TOKEN_WRONG, "客户端令牌错误");
                }
            } else {
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

    @Override
    public void loginout(BaseReq baseReq) {

    }

    @Override
    public BaseResp bindPhone(BaseReq baseReq) {
        return null;
    }

    @Override
    public BaseResp changePassword(BaseReq baseReq) {
        return null;
    }

    @Override
    public BaseResp checkLoginName(BaseReq baseReq) {
        return null;
    }

    @Override
    public BaseResp checkLoginPhone(BaseReq baseReq) {
        return null;
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
