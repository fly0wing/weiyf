package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;


/**
 * 终端解绑请求
 *
 * @author Youyi Xiao
 *
 */
public class TerminalUnbindReq extends BaseReq {
    private long terminalId;
    private String fingerprint;
    private TerminalBindType terminalBindType;
}
