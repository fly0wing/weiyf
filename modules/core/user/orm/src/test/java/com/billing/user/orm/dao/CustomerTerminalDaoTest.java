package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerTerminal;
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
public class CustomerTerminalDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerTerminalDaoTest.class);
    @Autowired
    CustomerTerminalDao customerTerminalDao;

    @Test
    public void testGet() throws Exception {
        CustomerTerminal customerTerminal = customerTerminalDao.get(1L);
        logger.info(customerTerminal.toString());
        assertNotNull(customerTerminal);
    }

    @Test
    public void testSearch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", "");
        params.put("customerId", "");
        params.put("terminalId", "");
        params.put("terminalName", "");
        params.put("bindStatusId", "");
        params.put("currentOpTimeBegin", "");
        params.put("currentOpTimeEnd", "");
        params.put("lastOpTimeBegin", "");
        params.put("lastOpTimeEnd", "");
        params.put("firstBindTimeBegin", "");
        params.put("firstBindTimeEnd", "");
        params.put("isAutoLogin", "");
        params.put("lastLoginToken", "");
        List<CustomerTerminal> search = customerTerminalDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Test
    public void testSave() throws Exception {
        Object o = new Object();
        CustomerTerminal customerTerminal = new CustomerTerminal();
//        customerTerminal.setId(o);
//        customerTerminal.setCustomerId(o);
//        customerTerminal.setTerminalId(o);
//        customerTerminal.setTerminalName(o);
//        customerTerminal.setBindStatusId(o);
//        customerTerminal.setCurrentOpTime(o);
//        customerTerminal.setLastOpTime(o);
//        customerTerminal.setFirstBindTime(o);
//        customerTerminal.setIsAutoLogin(o);
//        customerTerminal.setLastLoginToken(o);
        boolean save = customerTerminalDao.save(customerTerminal);
        assertTrue(save);
    }

    @Test
    public void testUpdate() throws Exception {
        Object o = new Object();
        CustomerTerminal customerTerminal = new CustomerTerminal();
//        customerTerminal.setId(o);
//        customerTerminal.setCustomerId(o);
//        customerTerminal.setTerminalId(o);
//        customerTerminal.setTerminalName(o);
//        customerTerminal.setBindStatusId(o);
//        customerTerminal.setCurrentOpTime(o);
//        customerTerminal.setLastOpTime(o);
//        customerTerminal.setFirstBindTime(o);
//        customerTerminal.setIsAutoLogin(o);
//        customerTerminal.setLastLoginToken(o);
        boolean update = customerTerminalDao.update(customerTerminal);
        assertTrue(update);
    }

    @Test
    public void testDelete() throws Exception {
        boolean delete = customerTerminalDao.delete(1L);
        logger.info(delete + "~~~~~~~~~~~");
        assertTrue(delete);
    }
}