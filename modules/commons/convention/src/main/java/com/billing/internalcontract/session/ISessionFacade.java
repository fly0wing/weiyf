package com.billing.internalcontract.session;

import com.billing.internalcontract.UserSession;

/**
 * 会话服务
 * Created by xiaoyouyi on 2014-8-26.
 */
public interface ISessionFacade {

    UserSession getSessionById(long sessionId);

    UserSession getSessionByGuid(String guid);
}
