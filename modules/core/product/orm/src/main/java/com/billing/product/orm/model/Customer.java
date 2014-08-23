package com.billing.product.orm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangkai on 2014/8/22.
 */
public class Customer implements Serializable {
    private Long id;
    private String customerName;
    private String email;
    private String phone;
    private String passwordHint;
    private Long statusId;
    private String lastCurrencyUom;
    private String lastLocale;
    private String lastTimeZone;
    private Date disabledDateTime;
    private Long firstPartyId;
    private Date lastUpdatedStamp;
    private Date createdStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getLastCurrencyUom() {
        return lastCurrencyUom;
    }

    public void setLastCurrencyUom(String lastCurrencyUom) {
        this.lastCurrencyUom = lastCurrencyUom;
    }

    public String getLastLocale() {
        return lastLocale;
    }

    public void setLastLocale(String lastLocale) {
        this.lastLocale = lastLocale;
    }

    public String getLastTimeZone() {
        return lastTimeZone;
    }

    public void setLastTimeZone(String lastTimeZone) {
        this.lastTimeZone = lastTimeZone;
    }

    public Date getDisabledDateTime() {
        return disabledDateTime;
    }

    public void setDisabledDateTime(Date disabledDateTime) {
        this.disabledDateTime = disabledDateTime;
    }

    public Long getFirstPartyId() {
        return firstPartyId;
    }

    public void setFirstPartyId(Long firstPartyId) {
        this.firstPartyId = firstPartyId;
    }

    public Date getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Date lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public Date getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Date createdStamp) {
        this.createdStamp = createdStamp;
    }
}
