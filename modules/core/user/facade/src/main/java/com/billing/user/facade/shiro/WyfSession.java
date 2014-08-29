package com.billing.user.facade.shiro;

import com.billing.internalcontract.UserSession;
import org.apache.shiro.session.mgt.SimpleSession;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
public class WyfSession extends SimpleSession {
    private UserSession userSession;

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

}
