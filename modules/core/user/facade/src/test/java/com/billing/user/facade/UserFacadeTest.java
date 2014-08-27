package com.billing.user.facade;

import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.user.IUserFacade;
import com.billing.internalcontract.user.LoginAccountEnum;
import com.billing.internalcontract.user.LoginReq;
import com.billing.internalcontract.user.RegisterReq;
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

import java.util.Objects;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-facade.xml"})
@TransactionConfiguration(
        transactionManager = "userTransactionManager", defaultRollback = true)
@Transactional
@Service
public class UserFacadeTest {
    private static final Logger logger = LoggerFactory.getLogger(UserFacadeTest.class);

    @Autowired
    private IUserFacade userFacade;

    @Test
    public void testRegister() throws Exception {

    }

    @Test
    public void testLogin() throws Exception {
        LoginReq mock = mock(LoginReq.class);
        when(mock.getLoginAccountType()).thenReturn(LoginAccountEnum.Anonymous);
        when(mock.getLoginAccount()).thenReturn("76823243");

        BaseResp login = userFacade.login(mock);
        assertEquals(1, login.getCode());
    }

    @Test
    public void testLoginout() throws Exception {

    }

    @Test
    public void testBindPhone() throws Exception {

    }

    @Test
    public void testChangePassword() throws Exception {

    }

    @Test
    public void testCheckLoginName() throws Exception {

    }

    @Test
    public void testCheckLoginPhone() throws Exception {

    }

    @Test
    public void testRequestActionToken() throws Exception {

    }

    @Test
    public void testAuthActionToken() throws Exception {

    }
}