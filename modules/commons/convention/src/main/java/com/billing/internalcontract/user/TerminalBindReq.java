package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;


/**
 * 终端绑定请求
 *
 * @author Youyi Xiao
 *
 */
public class TerminalBindReq extends BaseReq {
    private TerminalBindEnum terminalBindType;
    private String terminalName;
}
