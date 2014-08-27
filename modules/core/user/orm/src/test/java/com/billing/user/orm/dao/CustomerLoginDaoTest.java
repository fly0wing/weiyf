package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerLogin;
import com.google.common.collect.Iterators;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-private.xml", "classpath:applicationContext-db-user.xml"})
@TransactionConfiguration(
        transactionManager = "userTransactionManager", defaultRollback = true)
@Transactional
public class CustomerLoginDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerLoginDaoTest.class);
    private Long testId = 1L;
    private String loginName = "testLoginName2014";
    private String loginEmail = "testLoginEmail2014@126.com";
    private String loginPhone = "15899999999";
    private String prefix = "p";
    private HashMap<String, Object> params = new HashMap<>();
    private CustomerLogin customerLogin = new CustomerLogin();

    @Autowired
    private CustomerLoginDao customerLoginDao;

    @Before
    public void initialize() {
        customerLogin.setCurrentPassword("123456");
        customerLogin.setEnabled(true);
        customerLogin.setFirstSessionId(1L);
        customerLogin.setId(testId);
        customerLogin.setIsAnonymous(false);
        customerLogin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        customerLogin.setLoginEmail(loginEmail);
        customerLogin.setLoginName(loginName);
        customerLogin.setLoginPhone(loginPhone);
        customerLogin.setNickname("mynickname");
        customerLogin.setRegisterTime(new Timestamp(System.currentTimeMillis()));
        customerLogin.setRequirePasswordChange(false);
        customerLogin.setSecurityLevel(1);

        params.put("id", testId);
        params.put("loginName", loginName);
        params.put("loginEmail", loginEmail);
        params.put("loginPhone", loginPhone);
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

    }

    @Test
    public void testCase() throws Exception {
        testSave();
        testGet();
        testGetByLoginEmail();
        testGetByLoginName();
        testGetByLoginPhone();
        testSearch();
        testUpdate();
        testDelete();
    }

    @Ignore("dao单元测试")
    @Test
    public void testGet() throws Exception {
        CustomerLogin customerLogin = customerLoginDao.get(testId);
        logger.info(customerLogin.toString());
        assertNotNull(customerLogin);
    }

    @Ignore("dao单元测试")
    @Test
    public void testSearch() throws Exception {
        params.put("id", testId);
        params.put("loginName", loginName);
        params.put("loginEmail", loginEmail);
        params.put("loginPhone", loginPhone);
        List<CustomerLogin> search = customerLoginDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Ignore("dao单元测试")
    @Test
    public void testSave() throws Exception {
        boolean save = customerLoginDao.save(customerLogin);
        testId = customerLogin.getId();
        logger.info(customerLogin.getId() + "~~~~");
        assertTrue(save);
    }

    @Ignore("dao单元测试")
    @Test
    public void testUpdate() throws Exception {
        customerLogin.setId(testId);
        customerLogin.setLoginEmail(prefix + loginEmail);
        customerLogin.setLoginName(prefix + loginName);
        customerLogin.setLoginPhone(prefix + loginPhone);
        boolean update = customerLoginDao.update(customerLogin);
        assertTrue(update);
    }

    @Ignore("dao单元测试")
    @Test
    public void testDelete() throws Exception {
        boolean delete = customerLoginDao.delete(customerLogin.getId());
        assertTrue(delete);
    }

    @Ignore("dao单元测试")
    @Test
    public void testGetByLoginName() {
        CustomerLogin update = customerLoginDao.getByLoginName(loginName);
        assertNotNull(update);
    }

    @Ignore("dao单元测试")
    @Test
    public void testGetByLoginEmail() {
        CustomerLogin update = customerLoginDao.getByLoginEmail(loginEmail);
        assertNotNull(update);
    }

    @Ignore("dao单元测试")
    @Test
    public void testGetByLoginPhone() {
        CustomerLogin update = customerLoginDao.getByLoginPhone(loginPhone);
        assertNotNull(update);
    }
}