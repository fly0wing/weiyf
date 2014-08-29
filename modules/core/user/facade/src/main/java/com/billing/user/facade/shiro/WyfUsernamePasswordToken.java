package com.billing.user.facade.shiro;

import com.billing.internalcontract.user.LoginAccountEnum;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
public class WyfUsernamePasswordToken extends UsernamePasswordToken {
    private LoginAccountEnum loginAccountEnum;

    public WyfUsernamePasswordToken(){
        super();
    }

    public WyfUsernamePasswordToken( LoginAccountEnum loginAccountEnum,final String username, final String password, final boolean rememberMe,final String host) {
        super(username, password != null ? password.toCharArray() : null, rememberMe, host);
        this.loginAccountEnum=loginAccountEnum;
    }

    public LoginAccountEnum getLoginAccountEnum() {
        return loginAccountEnum;
    }

    public void setLoginAccountEnum(LoginAccountEnum loginAccountEnum) {
        this.loginAccountEnum = loginAccountEnum;
    }
}
