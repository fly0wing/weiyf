package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;


/**
 * 终端激活请求
 *
 * @author Youyi Xiao
 *
 */
public class TerminalActiveReq extends BaseReq {
    /**
     * 终端类型标识
     */
    private long terminalTypeId;
    /**
     * 终端默认名称

     */
    private String defaultName;

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public long getTerminalTypeId() {
        return terminalTypeId;
    }

    public void setTerminalTypeId(long terminalTypeId) {
        this.terminalTypeId = terminalTypeId;
    }
}
