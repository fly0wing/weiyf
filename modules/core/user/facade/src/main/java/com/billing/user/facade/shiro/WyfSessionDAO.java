package com.billing.user.facade.shiro;

import com.billing.user.orm.dao.UserSessionDao;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
public class WyfSessionDAO extends CachingSessionDAO {

    @Autowired
    UserSessionDao userSessionDao;

    @Autowired
    private WyfSessionIdGenerator wyfSessionIdGenerator;
    /**
     * Subclass implementation hook to actually persist the {@code Session}'s state to the underlying EIS.
     *
     * @param session the session object whose state will be propagated to the EIS.
     */
    @Override
    protected void doUpdate(Session session) {

    }

    /**
     * Subclass implementation hook to permanently delete the given Session from the underlying EIS.
     *
     * @param session the session instance to permanently delete from the EIS.
     */
    @Override
    protected void doDelete(Session session) {

    }

    /**
     * Subclass hook to actually persist the given <tt>Session</tt> instance to the underlying EIS.
     *
     * @param session the Session instance to persist to the EIS.
     * @return the id of the session created in the EIS (i.e. this is almost always a primary key and should be the
     * value returned from {@link org.apache.shiro.session.Session#getId() Session.getId()}.
     */
    @Override
    protected Serializable doCreate(Session session) {
        return wyfSessionIdGenerator.generateId(session);
    }

    /**
     * Subclass implementation hook that retrieves the Session object from the underlying EIS or {@code null} if a
     * session with that ID could not be found.
     *
     * @param sessionId the id of the <tt>Session</tt> to retrieve.
     * @return the Session in the EIS identified by <tt>sessionId</tt> or {@code null} if a
     * session with that ID could not be found.
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }
}
