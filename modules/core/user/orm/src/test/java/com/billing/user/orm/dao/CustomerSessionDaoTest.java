package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerLogin;
import com.billing.user.orm.model.CustomerSession;
import com.google.common.collect.Iterators;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-private.xml","classpath:applicationContext-db-user.xml"})
// @TransactionConfiguration(
//        transactionManager = "", defaultRollback=true)
public class CustomerSessionDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerSessionDaoTest.class);
    @Autowired
    CustomerSessionDao customerSessionDao;
    Long id = 999L;
    HashMap<String, Object> params = new HashMap<>();
    CustomerSession customerSession = new CustomerSession();

    @Before
    public void initialize() {
        customerSession.setAppArea("一区");
        customerSession.setAppId(1L);
        customerSession.setCreateTime(new Timestamp(System.currentTimeMillis()));
        customerSession.setCustomerId(6L);
        customerSession.setDomainId("");
        customerSession.setEntryId(1L);
        customerSession.setGeoId(1L);
        customerSession.setId(id);
        customerSession.setIsAnonymous(false);
        customerSession.setPartyId(1L);
        customerSession.setProductId(1L);

        params.put("id",id);
        params.put("customerId","6");
        params.put("partyId","1");
        params.put("productId","1");
        params.put("domainId","1");
        params.put("appId","1");
        params.put("entryId","1");
        params.put("geoId","1");
        params.put("appArea","一区");
        params.put("isAnonymous",false);
        params.put("createTimeBegin","2014-01-01");
        params.put("createTimeEnd","2019-01-01");

    }

    @Test
    public void testCase() throws Exception {
        testSave();
        testGet();
        testSearch();
        testUpdate();
        testDelete();
    }

    @Test
    public void testGet() throws Exception {
        CustomerSession customerSession = customerSessionDao.get(id);
        logger.info(customerSession.toString());
        assertNotNull(customerSession);
    }

    @Test
    public void testSearch() throws Exception {
        List<CustomerSession> search = customerSessionDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Test
    public void testSave() throws Exception {
        boolean save = customerSessionDao.save(customerSession);
        logger.info(customerSession.getId() + "~~~~");
        assertTrue(save);
        id = customerSession.getId();
    }

    @Test
    public void testUpdate() throws Exception {
        boolean update = customerSessionDao.update(customerSession);
        assertTrue(update);
    }

    @Test
    public void testDelete() throws Exception {
        boolean delete = customerSessionDao.delete(id);
        assertTrue(delete);
    }
}