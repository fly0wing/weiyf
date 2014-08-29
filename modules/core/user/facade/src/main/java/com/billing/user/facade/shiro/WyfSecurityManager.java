package com.billing.user.facade.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
@Service
public class WyfSecurityManager extends DefaultSecurityManager {
    private static WyfSecurityManager singleton=null;
    public static WyfSecurityManager getInstance( ){
        if(singleton==null){
            singleton = new WyfSecurityManager();
        }
        return singleton;
    }
    @Autowired
    private WyfSessionDAO wyfSessionDAO;
    @Autowired
    private WyfSessionFactory wyfSessionFactory;
    @Autowired
    private WyfCacheManager wyfCacheManager;

    public WyfSecurityManager(){
        super();
        if(singleton ==null) {
            singleton=this;
        }
    }

    @PostConstruct
    private void init( ){
        setRealm(WyfJdbcRealm.getInstance() );
        DefaultSessionManager defaultSessionManager= ((DefaultSessionManager)getSessionManager());
        defaultSessionManager.setSessionDAO(wyfSessionDAO);
        defaultSessionManager.setSessionFactory(wyfSessionFactory);
        defaultSessionManager.setCacheManager(wyfCacheManager);
    }



}
