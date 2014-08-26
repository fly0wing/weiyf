package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;


/**
 * 注册请求
 *
 * @author Youyi Xiao
 *
 */
public class RegisterReq extends BaseReq {

    private boolean isAnonymous;
    private String nickName;
    private String password;
    private long fromPartyId;
    private String loginAccount;
    private LoginAccountEnum loginAccountType;

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getFromPartyId() {
        return fromPartyId;
    }

    public void setFromPartyId(long fromPartyId) {
        this.fromPartyId = fromPartyId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public LoginAccountEnum getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(LoginAccountEnum loginAccountType) {
        this.loginAccountType = loginAccountType;
    }
}
