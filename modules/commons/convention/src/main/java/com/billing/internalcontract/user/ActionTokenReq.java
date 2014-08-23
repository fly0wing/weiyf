package com.billing.internalcontract.user;

import com.billing.internalcontract.ActionTokenType;
import com.billing.internalcontract.BaseReq;


/**
 * 获取行动令牌请求
 *
 * @author Youyi Xiao
 *
 */
public class ActionTokenReq extends BaseReq {
    private ActionTokenType actionTokenType;
    private String phone;
}
