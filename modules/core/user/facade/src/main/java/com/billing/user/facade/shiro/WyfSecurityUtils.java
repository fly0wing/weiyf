package com.billing.user.facade.shiro;

import com.billing.internalcontract.UserSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;

/**
 * Created by xiaoyouyi on 2014-8-29.
 */
public abstract   class WyfSecurityUtils extends SecurityUtils {

    //private WyfSecurityUtils(){}

    private static Object monitor;

    public static UserSession getSession(){
        ensureInited();
        Session session= getSubject().getSession();
        UserSession userSession= (UserSession)session.getAttribute(WyfSecurityManager.SESSION_SESSION_KEY);
        return userSession;
    }

    public static Subject getSubject() {
        ensureInited();
        Subject subject = ThreadContext.getSubject();
        if (subject == null) {
            subject = (new Subject.Builder()).buildSubject();
            ThreadContext.bind(subject);
        }
        return subject;
    }
    private static void ensureInited(){
        if(monitor==null){
            monitor=new Object();
            WyfSecurityUtils.setSecurityManager( WyfSecurityManager.getInstance() );
        }
    }



}
