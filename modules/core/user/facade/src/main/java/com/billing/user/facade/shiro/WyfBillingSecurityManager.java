package com.billing.user.facade.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
public class WyfBillingSecurityManager extends DefaultSecurityManager {
    private static WyfBillingSecurityManager singleton=null;
    public static WyfBillingSecurityManager getInstance( ){
        if(singleton==null){
            singleton = new WyfBillingSecurityManager();
            singleton.init();
        }
        Long l;
        return singleton;
    }

    private WyfBillingSecurityManager(){
        WyfSecurityUtils.setSecurityManager(this);

    };

    private void init( ){
        setRealm(WyfJdbcRealm.getInstance() );
        ((DefaultSessionManager)getSessionManager()).setSessionFactory(new WyfSessionFactory());

    }


}
