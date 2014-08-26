package com.billing.internalcontract.user;

import com.billing.internalcontract.ActionTokenEnum;
import com.billing.internalcontract.BaseReq;


/**
 * 获取行动令牌请求
 *
 * @author Youyi Xiao
 *
 */
public class ActionTokenReq extends BaseReq {
    private ActionTokenEnum actionTokenType;
    private String phone;

    public ActionTokenEnum getActionTokenType() {
        return actionTokenType;
    }

    public void setActionTokenType(ActionTokenEnum actionTokenType) {
        this.actionTokenType = actionTokenType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
