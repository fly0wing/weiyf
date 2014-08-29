//package com.billing.user.facade;
//
//import com.billing.internalcontract.BaseResp;
//import com.billing.internalcontract.UserSession;
//import com.billing.internalcontract.user.IUserFacade;
//import com.billing.internalcontract.user.LoginAccountEnum;
//import com.billing.internalcontract.user.LoginReq;
//import org.junit.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// * Created by zkai on 2014/8/27.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@DirtiesContext
//@ContextConfiguration(locations = {"classpath:applicationContext-facade.xml"})
//@TransactionConfiguration(
//        transactionManager = "userTransactionManager", defaultRollback = true)
//@Transactional
//@Service
//public class UserFacadeCase {
//
//    private static final Logger logger = LoggerFactory.getLogger(UserFacadeTest.class);
//
//    @Autowired
//    private IUserFacade userFacade;
//
//    /**
//     * 匿名登录情况.
//     * @throws Exception
//     */
//    @Test
//    public void testAnonymousLoginCase() throws Exception {
//        LoginReq loginReq = new LoginReq();
//        loginReq.setLoginAccountType(LoginAccountEnum.Anonymous);
//        loginReq.setAuto(true);
//
//        UserSession userSession = new UserSession();
//        userSession.setSessionToken("111111");
//
//        loginReq.setSession(userSession);
//
//        BaseResp login = userFacade.login(loginReq);
//        assertEquals(1, login.getCode());
//    }
//
//    @Test
//    public void testLoginEmailCase() throws Exception {
//        LoginReq loginReq = new LoginReq();
//        loginReq.setLoginAccountType(LoginAccountEnum.LoginEmail);
//        loginReq.setLoginAccount("");
//        UserSession userSession = mock(UserSession.class);
//        when(userSession.getSessionToken()).thenReturn("1111111111");
//        loginReq.setSession(userSession);
//        BaseResp login = userFacade.login(loginReq);
//        assertEquals(0, login.getCode());
//    }
//
//    @Test
//    public void testLoginNameCase() throws Exception {
//        LoginReq loginReq = new LoginReq();
//        loginReq.setLoginAccountType(LoginAccountEnum.LoginName);
//        UserSession userSession = mock(UserSession.class);
//        when(userSession.getSessionToken()).thenReturn("1111111111");
//        loginReq.setSession(userSession);
//        BaseResp login = userFacade.login(loginReq);
//        assertEquals(0, login.getCode());
//    }
//
//    @Test
//    public void testLoginPhoneCase() throws Exception {
//        LoginReq loginReq = new LoginReq();
//        loginReq.setLoginAccountType(LoginAccountEnum.LoginPhone);
//        UserSession userSession = mock(UserSession.class);
//        when(userSession.getSessionToken()).thenReturn("1111111111");
//        loginReq.setSession(userSession);
//        BaseResp login = userFacade.login(loginReq);
//        assertEquals(0, login.getCode());
//    }
//}
