package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerSessionDurable;
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

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-private.xml","classpath:applicationContext-db-user.xml"})
@TransactionConfiguration(
        transactionManager = "userTransactionManager", defaultRollback=true)
public class CustomerSessionDurableDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerSessionDurableDaoTest.class);
    @Autowired
    CustomerSessionDurableDao customerSessionDurableDao;

    @Test
    public void testGet() throws Exception {
        CustomerSessionDurable customerSessionDurable = customerSessionDurableDao.get(1L);
        logger.info(customerSessionDurable.toString());
        assertNotNull(customerSessionDurable);
    }

    @Test
    public void testSearch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", "");
        params.put("customerId", "");
        params.put("partyId", "");
        params.put("productId", "");
        params.put("domainId", "");
        params.put("appId", "");
        params.put("entryId", "");
        params.put("geoId", "");
        params.put("appArea", "");
        params.put("isAnonymous", "");
        params.put("createTimeBegin", "");
        params.put("createTimeEnd", "");
        List<CustomerSessionDurable> search = customerSessionDurableDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Test
    public void testSave() throws Exception {
        Object o = new Object();
        CustomerSessionDurable customerSessionDurable = new CustomerSessionDurable();
//        customerSessionDurable.setId(o);
//        customerSessionDurable.setCustomerId(o);
//        customerSessionDurable.setPartyId(o);
//        customerSessionDurable.setProductId(o);
//        customerSessionDurable.setDomainId(o);
//        customerSessionDurable.setAppId(o);
//        customerSessionDurable.setEntryId(o);
//        customerSessionDurable.setGeoId(o);
//        customerSessionDurable.setAppArea(o);
//        customerSessionDurable.setIsAnonymous(o);
//        customerSessionDurable.setCreateTime(o);
        boolean save = customerSessionDurableDao.save(customerSessionDurable);
        assertTrue(save);
    }

    @Test
    public void testUpdate() throws Exception {
        Object o = new Object();
        CustomerSessionDurable customerSessionDurable = new CustomerSessionDurable();
//        customerSessionDurable.setId(o);
//        customerSessionDurable.setCustomerId(o);
//        customerSessionDurable.setPartyId(o);
//        customerSessionDurable.setProductId(o);
//        customerSessionDurable.setDomainId(o);
//        customerSessionDurable.setAppId(o);
//        customerSessionDurable.setEntryId(o);
//        customerSessionDurable.setGeoId(o);
//        customerSessionDurable.setAppArea(o);
//        customerSessionDurable.setIsAnonymous(o);
//        customerSessionDurable.setCreateTime(o);
        boolean update = customerSessionDurableDao.update(customerSessionDurable);
        assertTrue(update);
    }

    @Test
    public void testDelete() throws Exception {
        boolean delete = customerSessionDurableDao.delete(1L);
        logger.info(delete + "~~~~~~~~~~~");
        assertTrue(delete);
    }
}