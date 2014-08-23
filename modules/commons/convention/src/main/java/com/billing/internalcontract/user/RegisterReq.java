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
}
