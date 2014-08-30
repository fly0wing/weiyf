package com.billing.user.facade.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
@Service
public class WyfSecurityManager extends DefaultSecurityManager {
    public final static  String SESSION_SESSION_KEY="session_session_key";
    private static WyfSecurityManager singleton=null;
    public static WyfSecurityManager getInstance( ){
        if(singleton==null){
            singleton = new WyfSecurityManager();
        }
        return singleton;
    }
    //@Autowired
    //private WyfSessionDAO wyfSessionDAO;
    @Autowired
    private WyfSessionFactory wyfSessionFactory;
    @Autowired
    private WyfCacheManager wyfCacheManager;

    @Autowired
    @Qualifier("wyfSessionManager")
    @Override
    public void setSessionManager(SessionManager sessionManager) {
        super.setSessionManager(sessionManager);
    }

    private WyfSecurityManager(){
        super();
        if(singleton ==null) {
            singleton=this;
        }
    }

    @PostConstruct
    private void init( ){
        setRealm(WyfJdbcRealm.getInstance() );
        WyfSessionManager wyfSessionManager= ((WyfSessionManager)getSessionManager());
        //defaultSessionManager.setSessionDAO(wyfSessionDAO);
        wyfSessionManager.setSessionFactory(wyfSessionFactory);
        wyfSessionManager.setCacheManager(wyfCacheManager);

        WyfSecurityUtils.setSecurityManager( this );
    }



}
