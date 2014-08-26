package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;

/**
 * 登录请求
 *
 * @author Youyi Xiao
 *
 */
public class LoginReq extends BaseReq {
    /**
     * 是否自动登录

     */
    private boolean isAuto;
    private LoginAccountEnum loginAccountType;
    private String loginAccount;
    private String password;

    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean isAuto) {
        this.isAuto = isAuto;
    }

    public LoginAccountEnum getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(LoginAccountEnum loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
