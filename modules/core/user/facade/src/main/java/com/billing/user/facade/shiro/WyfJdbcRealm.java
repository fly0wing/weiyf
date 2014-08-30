package com.billing.user.facade.shiro;

import com.billing.internalcontract.user.IUserFacade;
import com.billing.user.orm.dao.CustomerLoginDao;
import com.billing.user.orm.model.CustomerLogin;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
public class WyfJdbcRealm extends JdbcRealm {

    private static final Logger log = LoggerFactory.getLogger(WyfJdbcRealm.class);

    @Autowired
    private CustomerLoginDao customerLoginDao;

    @Autowired
    private IUserFacade userFacade;

    private static WyfJdbcRealm singleton = new WyfJdbcRealm();
    public static WyfJdbcRealm getInstance( ){
        return singleton;
    }

    private WyfJdbcRealm(){
        this.setName("WyfJdbcRealm");
    }


    /**
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        WyfUsernamePasswordToken upToken = ( WyfUsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        AuthenticationInfo info = null;
        CustomerLogin customerLogin=null;
        try {
            switch (upToken.getLoginAccountEnum()) {
                case Anonymous:
                    customerLogin = customerLoginDao.getByLoginName( username);
                    break;
                case LoginName:
                    customerLogin = customerLoginDao.getByLoginName( username);
                    break;
                case LoginEmail:
                    customerLogin = customerLoginDao.getByLoginEmail( username);
                    break;
                case LoginPhone:
                    customerLogin = customerLoginDao.getByLoginPhone( username);
                    break;
            }

            if (customerLogin == null) {
                throw new UnknownAccountException("No account found for user [" + username + "]");
            }

            SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(username, customerLogin.getCurrentPassword(), getName());
            /**
             * This (very bad) example uses the username as the salt in this sample app.  DON'T DO THIS IN A REAL APP!
             *
             * Salts should not be based on anything that a user could enter (attackers can exploit this).  Instead
             * they should ideally be cryptographically-strong randomly generated numbers.
             */
            saInfo.setCredentialsSalt(ByteSource.Util.bytes(username));

            info = saInfo;

        } catch (Exception e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";
            if (log.isErrorEnabled()) {
                log.error(message, e);
            }

            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        } finally {
        }

        return info;
    }

}
