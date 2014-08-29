package com.billing.user.facade.shiro;

import com.billing.internalcontract.user.LoginAccountEnum;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
public class WyfUsernamePasswordToken extends UsernamePasswordToken {
    private LoginAccountEnum loginAccountEnum;

    public LoginAccountEnum getLoginAccountEnum() {
        return loginAccountEnum;
    }

    public void setLoginAccountEnum(LoginAccountEnum loginAccountEnum) {
        this.loginAccountEnum = loginAccountEnum;
    }
}
