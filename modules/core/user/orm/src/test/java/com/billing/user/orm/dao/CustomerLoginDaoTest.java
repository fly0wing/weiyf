package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerLogin;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-private.xml", "classpath:applicationContext-db-user.xml"})
// @TransactionConfiguration(
//        transactionManager = "", defaultRollback=true)
public class CustomerLoginDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerLoginDaoTest.class);
    @Autowired
    CustomerLoginDao customerLoginDao;

    @Test
    public void testGet() throws Exception {
        CustomerLogin customerLogin = customerLoginDao.get(6L);
        logger.info(customerLogin.toString());
        assertNotNull(customerLogin);
    }

    @Test
    public void testSearch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", "6");
        params.put("loginName", "testLoginName1");
        params.put("loginEmail", "testLoginEmai1l@126.com");
        params.put("loginPhone", "15800000100");
        params.put("nickname", "mynickname");
        params.put("isAnonymous", false);
        params.put("currentPassword", "123456");
        params.put("enabled", true);
        params.put("firstSessionId", "1");
        params.put("requirePasswordChange", false);
        params.put("securityLevel", "1");
        params.put("registerTimeBegin", "2013-01-01");
        params.put("registerTimeEnd", "2015-01-01");
        params.put("lastLoginTimeBegin", "2013-01-01");
        params.put("lastLoginTimeEnd", "2015-01-01");
        List<CustomerLogin> search = customerLoginDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Test
    public void testSave() throws Exception {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setCurrentPassword("123456");
        customerLogin.setEnabled(true);
        customerLogin.setFirstSessionId(1L);
        customerLogin.setId(6L);
        customerLogin.setIsAnonymous(false);
        customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        customerLogin.setLoginEmail("testLoginEmail@126.com");
        customerLogin.setLoginName("testLoginName");
        customerLogin.setLoginPhone("15800000000");
        customerLogin.setNickname("mynickname");
        customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
        customerLogin.setRequirePasswordChange(false);
        customerLogin.setSecurityLevel(1);
        boolean save = customerLoginDao.save(customerLogin);
        logger.info(customerLogin.getId() + "~~~~");
        assertTrue(save);
    }

    @Test
    public void testUpdate() throws Exception {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setCurrentPassword("123456");
        customerLogin.setEnabled(true);
        customerLogin.setFirstSessionId(1L);
        customerLogin.setId(6L);
        customerLogin.setIsAnonymous(false);
        customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        customerLogin.setLoginEmail("testLoginEmai1l@126.com");
        customerLogin.setLoginName("testLoginName1");
        customerLogin.setLoginPhone("15800000100");
        customerLogin.setNickname("mynickname");
        customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
        customerLogin.setRequirePasswordChange(false);
        customerLogin.setSecurityLevel(1);
        boolean update = customerLoginDao.update(customerLogin);
        assertTrue(update);
    }

    @Test
    public void testDelete() throws Exception {
        boolean delete = customerLoginDao.delete(8L);
        logger.info(delete + "~~~~~~~~~~~");
        assertTrue(delete);
    }

    @Test
    public void testGetByLoginName() {
        CustomerLogin update = customerLoginDao.getByLoginName("testLoginName1");
        assertNotNull(update);
    }

    @Test
    public void testGetByLoginEmail() {
        CustomerLogin update = customerLoginDao.getByLoginEmail("testLoginEmai1l@126.com");
        assertNotNull(update);
    }

    @Test
    public void testGetByLoginPhone() {
        CustomerLogin update = customerLoginDao.getByLoginPhone("15800000100");
        assertNotNull(update);
    }
}