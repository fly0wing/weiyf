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

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public TerminalBindEnum getTerminalBindType() {
        return terminalBindType;
    }

    public void setTerminalBindType(TerminalBindEnum terminalBindType) {
        this.terminalBindType = terminalBindType;
    }
}
