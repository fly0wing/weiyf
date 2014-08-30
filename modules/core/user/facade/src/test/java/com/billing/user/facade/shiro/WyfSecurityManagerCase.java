package com.billing.user.facade.shiro;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.UserSession;
import com.billing.internalcontract.user.*;
import com.billing.user.facade.UserFacadeTest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zkai on 2014/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-facade.xml"})
@TransactionConfiguration(
        transactionManager = "userTransactionManager", defaultRollback = true)
@Transactional
@Service
public class WyfSecurityManagerCase {
    private static final Logger log = LoggerFactory.getLogger(WyfSecurityManagerCase.class);

    @Autowired
    private WyfSecurityManager wyfSecurityManager;

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private IUserTerminalFacade userTerminalFacade;

    private Subject currentUser;
    private UserSession session;

    /**
     * 基本的用例测试.
     *
     * @throws Exception
     */
    @Test
    public void basicUsageCase() throws Exception {
        // get the currently executing user:
        WyfSecurityUtils.setSecurityManager( wyfSecurityManager );
        currentUser = WyfSecurityUtils.getSubject();

        // Do some stuff with a Session (no need for a web or EJB container!!!)
        session = WyfSecurityUtils.getSession();
        simulateContext();
        if (session.getTerminalId() == 0) {
            activateTerminal(2);
        }
        if (session.getCustomerId() == 0) {
            register(2);
            bindTerminal(2);
        }

        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (!value.equals("aValue")) {
            log.error("Retrieved " +
                    "反反复复反复 the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
            WyfUsernamePasswordToken token = new WyfUsernamePasswordToken(LoginAccountEnum.LoginName, "yyx", "123456", true, "Huawei-mate2");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                login(3);
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level)
        if (currentUser.isPermitted("lightsaber:weild")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        currentUser.logout();
        logout(3);

    }

    private void activateTerminal(int count) {
        for (int i = 0; i < count; i++) {
            TerminalActiveReq req = new TerminalActiveReq();
            BaseResp resq = userTerminalFacade.activeTerminal(req);
        }
    }

    private void bindTerminal(int count) {
        for (int i = 0; i < count; i++) {
            TerminalBindReq req = new TerminalBindReq();
            req.setTerminalBindType(TerminalBindEnum.Register);
            req.setTerminalName("YYX华为Mate2");
            BaseResp resq = userTerminalFacade.bindTerminal(req);
        }
    }

    private void register(int count) {
        for (int i = 0; i < count; i++) {
            RegisterReq req = new RegisterReq();
            req.setLoginAccountType(LoginAccountEnum.LoginName);
            req.setLoginAccount("yyx");
            req.setPassword("123456");
            BaseResp resq = userFacade.register(req);
        }
    }

    private void login(int count) {
        for (int i = 0; i < count; i++) {
            LoginReq req = new LoginReq();

            userFacade.login(req);
        }
    }


    private void logout(int count) {
        for (int i = 0; i < count; i++) {
            RegisterReq req = new RegisterReq();
            userFacade.loginout(req);
        }
    }

    private void simulateContext() {
        session.setFingerprint("sdfasfasdwefafa2323sfasfsaf");
    }


}
