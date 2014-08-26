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
    private TerminalBindEnum terminalBindType;

    public long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(long terminalId) {
        this.terminalId = terminalId;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public TerminalBindEnum getTerminalBindType() {
        return terminalBindType;
    }

    public void setTerminalBindType(TerminalBindEnum terminalBindType) {
        this.terminalBindType = terminalBindType;
    }
}
