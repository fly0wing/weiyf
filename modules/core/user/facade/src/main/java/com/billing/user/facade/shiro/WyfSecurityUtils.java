package com.billing.user.facade.shiro;

import com.billing.internalcontract.UserSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * Created by xiaoyouyi on 2014-8-29.
 */
public abstract class WyfSecurityUtils extends SecurityUtils {

    public static UserSession getSession(){
        Session session= getSubject().getSession();
        UserSession userSession= (UserSession)session.getAttribute(WyfSecurityManager.SESSION_SESSION_KEY);
        return userSession;
    }



}
