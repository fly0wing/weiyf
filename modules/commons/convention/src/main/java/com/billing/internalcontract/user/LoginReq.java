package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;

/**
 * 登录请求
 *
 * @author Youyi Xiao
 *
 */
public class LoginReq extends BaseReq {
    private boolean isAnonymous;
    private long fromPartyId;
    private String loginAccount;
    private String password;
    private LoginAccountType loginAccountType;

}
