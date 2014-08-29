package com.billing.user.facade.shiro;

import com.billing.internalcontract.UserSession;
import com.billing.user.facade.SessionFacade;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.springframework.stereotype.Component;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
@Component
public class WyfSessionFactory implements SessionFactory {
    /**
     * Creates a new {@code Session} instance based on the specified contextual initialization data.
     *
     * @param initData the initialization data to be used during {@link org.apache.shiro.session.Session} creation.
     * @return a new {@code Session} instance.
     * @since 1.0
     */
    @Override
    public Session createSession(SessionContext initData) {
        UserSession userSession = new UserSession();
        userSession.setFingerprint(initData.getHost());
        //todo  userSession.setSessionId(Long.parseLong(initData.getSessionId());

        return userSession;
    }
}
