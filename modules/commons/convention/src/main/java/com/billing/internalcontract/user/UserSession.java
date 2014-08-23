package com.billing.internalcontract.user;

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
     * 客户端产生的会话标识
     */
    private String sessionToken;
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
     * 当前的入口标识
     */
    private long entryId;
}
