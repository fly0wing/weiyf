package com.billing.internalcontract;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiaoyouyi on 2014-6-21.
 */
public class BaseReq implements Serializable {
    /**
     * 请求的唯一标识
     */
    private String requestGuid;
    /**
     * 请求时间
     */
    private Date requestTime;
    /**
     * 当前的会话
     */

    private UserSession session;
    /**
     * 数字参数1
     */
    private long longReq;
    /**
     * 字符串参数1，依次使用
     */
    private String stringReq;
    private long longReq2;
    private String stringReq2;
    private long longReq3;
    private String stringReq3;
    /**
     * 请求actionToken时的reuestGuid
     */
    private String atRequestGuid;
    /**
     * 用户输入的令牌
     */
    private String actionToken;

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }

    public String getRequestGuid() {
        return requestGuid;
    }

    public void setRequestGuid(String requestGuid) {
        this.requestGuid = requestGuid;
    }

    public long getLongReq() {
        return longReq;
    }

    public void setLongReq(long longReq) {
        this.longReq = longReq;
    }

    public String getStringReq() {
        return stringReq;
    }

    public void setStringReq(String stringReq) {
        this.stringReq = stringReq;
    }

    public long getLongReq2() {
        return longReq2;
    }

    public void setLongReq2(long longReq2) {
        this.longReq2 = longReq2;
    }

    public String getStringReq2() {
        return stringReq2;
    }

    public void setStringReq2(String stringReq2) {
        this.stringReq2 = stringReq2;
    }

    public long getLongReq3() {
        return longReq3;
    }

    public void setLongReq3(long longReq3) {
        this.longReq3 = longReq3;
    }

    public String getStringReq3() {
        return stringReq3;
    }

    public void setStringReq3(String stringReq3) {
        this.stringReq3 = stringReq3;
    }

    public String getAtRequestGuid() {
        return atRequestGuid;
    }

    public void setAtRequestGuid(String atRequestGuid) {
        this.atRequestGuid = atRequestGuid;
    }

    public String getActionToken() {
        return actionToken;
    }

    public void setActionToken(String actionToken) {
        this.actionToken = actionToken;
    }


}
