package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.user.ActionTokenReq;
import com.billing.internalcontract.user.IUserFacade;
import com.billing.internalcontract.user.LoginReq;
import com.billing.internalcontract.user.RegisterReq;
import com.billing.user.orm.dao.CustomerLoginDao;
import com.billing.user.orm.dao.CustomerTerminalDao;
import com.billing.user.orm.model.CustomerLogin;

import java.util.function.Predicate;

/**
 * Created by zkai on 2014/8/26.
 */
public class UserFacade implements IUserFacade {
    private CustomerLoginDao loginDao;
    private CustomerTerminalDao terminalDao;
    @Override
    public BaseResp register(RegisterReq registerReq) {

        return null;
    }

    @Override
    public BaseResp login(LoginReq loginReq) {
        BaseResp baseResp = new BaseResp(true);
        CustomerLogin customerLoginDao = null;
        if(loginReq.isAuto()){

        }else {
            switch (loginReq.getLoginAccountType()) {
                case Anonymous:
                    break;
                case LoginName:
                     customerLoginDao = loginDao.getByLoginName(loginReq.getLoginAccount());
                    // TODO:password salt
                    if(loginReq.getPassword().equals(customerLoginDao.getCurrentPassword())){

                    }else{
                        baseResp.
                    }
                    break;
                case LoginEmail:
                     customerLoginDao = loginDao.getByLoginEmail(loginReq.getLoginAccount());
                    // TODO:password salt
                    if(loginReq.getPassword().equals(customerLoginDao.getCurrentPassword())){

                    }else{

                    }
                    break;
                case LoginPhone:
                    customerLoginDao = loginDao.getByLoginPhone(loginReq.getLoginAccount());
                    // TODO:password salt
                    if(loginReq.getPassword().equals(customerLoginDao.getCurrentPassword())){

                    }else{

                    }
                    break;
            }
        }
        return null;
    }
    private static BaseResp chkPassword(Predicate condition) {

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
