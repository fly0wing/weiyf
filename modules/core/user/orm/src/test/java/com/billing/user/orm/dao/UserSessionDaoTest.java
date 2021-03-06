package com.billing.user.orm.dao;

import com.billing.user.orm.model.UserSession;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-private.xml","classpath:applicationContext-db-user.xml"})
// @TransactionConfiguration(
//        transactionManager = "", defaultRollback=true)
public class UserSessionDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(UserSessionDaoTest.class);
    @Autowired
    UserSessionDao userSessionDao;

    @Test
    public void testGet() throws Exception {
        assertNotNull(null);
    }

    @Test
    public void testSearch() throws Exception {
        assertNotNull(null);
    }

    @Test
    public void testSave() throws Exception {
        assertNotNull(null);
    }

    @Test
    public void testUpdate() throws Exception {
        assertNotNull(null);
    }

    @Test
    public void testDelete() throws Exception {
        assertNotNull(null);
    }
}