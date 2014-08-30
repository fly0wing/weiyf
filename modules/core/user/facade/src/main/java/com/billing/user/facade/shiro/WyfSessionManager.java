package com.billing.user.facade.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.*;
import org.springframework.stereotype.Service;

/**
 * Created by xiaoyouyi on 2014-8-30.
 */
@Service
public class WyfSessionManager extends DefaultSessionManager {

    @Override
    protected Session createExposedSession(Session session, SessionContext context) {
        DelegatingSession delegatingSession= new DelegatingSession(this, new DefaultSessionKey(session.getId()));
        delegatingSession.setAttribute(WyfSecurityManager.SESSION_SESSION_KEY,session);
        return delegatingSession;
    }

    @Override
    protected Session createExposedSession(Session session, SessionKey key) {
        DelegatingSession delegatingSession= new DelegatingSession(this, new DefaultSessionKey(session.getId()));
        delegatingSession.setAttribute(WyfSecurityManager.SESSION_SESSION_KEY,session);
        return delegatingSession;
    }
}
