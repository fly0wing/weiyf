package com.billing.internalcontract;

import com.billing.internalcontract.user.UserSession;

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
    private UserSession session;
    private long longReq;
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


}
