package com.billing.internalcontract;

import com.billing.internalcontract.BaseReq;


/**
 * 用户会话
 *
 * @author Youyi Xiao
 *
 */
public class UserSession {
    /**
     * 服务端产生的的会话标识
     */
    private long sessionId;
    /**
     * 客户端产生的会话标识：UUID
     */
    private String sessionToken;

    /**
     * 终端标识
     */
    private long terminalId;

    /**
     * 用户标识，用户登录（含匿名及自动登录）后才存在
     */
    private long customerId;
    /**
     * 终端指纹
     */
    private String fingerprint;
    /**
     * 在用户安全设置要求绑定验证时，即使已经成功验证登录密码，设备也不能算已经绑定在该用户名下。
     */
    private boolean isBound;
    /**
     * 当前的商户标识
     */
    private long partyId;
    /**
     * 当前的入口应用标识
     */
    private long appId;
    /**
     * 当前的入口标识
     */
    private long entryId;
    /**
     * 地理标位置识
     */
    private long geoId;

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(long terminalId) {
        this.terminalId = terminalId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public boolean isBound() {
        return isBound;
    }

    public void setBound(boolean isBound) {
        this.isBound = isBound;
    }

    public long getPartyId() {
        return partyId;
    }

    public void setPartyId(long partyId) {
        this.partyId = partyId;
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public long getGeoId() {
        return geoId;
    }

    public void setGeoId(long geoId) {
        this.geoId = geoId;
    }
}
