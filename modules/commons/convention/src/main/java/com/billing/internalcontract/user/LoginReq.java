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
    private LoginAccountType loginAccountType;
    private String loginAccount;
    private String password;


}
