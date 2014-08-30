package com.billing.user.orm.business_model;

import java.io.Serializable;

/**
 * Created by Xenox on 2014/8/29.
 */
public class TerminalInfo implements Serializable {

    /**
     * db_column: customer_id
     * remarks from db:用户标识
     */
    private Long customerId;

    /**
     * db_column: terminal_id
     * remarks from db:终端标识
     */
    private Long terminalId;

    /**
     * db_column: terminal_name
     * remarks from db:终端名称
     */
    private String terminalName;

    /**
     * db_column: fingerprint
     * remarks from db:终端指纹
     */
    private String fingerprint;


    public void setCustomerId(Long value) {
        this.customerId = value;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setTerminalId(Long value) {
        this.terminalId = value;
    }

    public Long getTerminalId() {
        return this.terminalId;
    }

    public void setTerminalName(String value) {
        this.terminalName = value;
    }

    public String getTerminalName() {
        return this.terminalName;
    }

    public void setFingerprint(String value) {
        this.fingerprint = value;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }
}
