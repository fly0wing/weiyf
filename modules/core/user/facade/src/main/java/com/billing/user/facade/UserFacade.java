package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.user.ActionTokenReq;
import com.billing.internalcontract.user.IUserFacade;
import com.billing.internalcontract.user.LoginReq;
import com.billing.internalcontract.user.RegisterReq;

/**
 * Created by zkai on 2014/8/26.
 */
public class UserFacade implements IUserFacade {
    @Override
    public BaseResp register(RegisterReq registerReq) {
        return null;
    }

    @Override
    public BaseResp login(LoginReq loginReq) {
        return null;
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
