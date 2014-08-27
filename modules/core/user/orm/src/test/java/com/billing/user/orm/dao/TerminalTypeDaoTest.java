package com.billing.user.orm.dao;

import com.billing.user.orm.model.TerminalType;
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
public class TerminalTypeDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(TerminalTypeDaoTest.class);
    @Autowired
    TerminalTypeDao terminalTypeDao;

    @Test
    public void testGet() throws Exception {
        TerminalType terminalType = terminalTypeDao.get(1L);
        logger.info(terminalType.toString());
        assertNotNull(terminalType);
    }

    @Test
    public void testSearch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("terminalTypeId", "");
        params.put("parentTypeId", "");
        params.put("osType", "");
        params.put("screenSizeEnumId", "");
        params.put("description", "");
        params.put("lastModifiedDateBegin", "");
        params.put("lastModifiedDateEnd", "");
        params.put("lastModifiedByUserLogin", "");
        params.put("createdDateBegin", "");
        params.put("createdDateEnd", "");
        params.put("createdByUserLogin", "");
        List<TerminalType> search = terminalTypeDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Test
    public void testSave() throws Exception {
        Object o = new Object();
        TerminalType terminalType = new TerminalType();
//        terminalType.setTerminalTypeId(o);
//        terminalType.setParentTypeId(o);
//        terminalType.setOsType(o);
//        terminalType.setScreenSizeEnumId(o);
//        terminalType.setDescription(o);
//        terminalType.setLastModifiedDate(o);
//        terminalType.setLastModifiedByUserLogin(o);
//        terminalType.setCreatedDate(o);
//        terminalType.setCreatedByUserLogin(o);
        boolean save = terminalTypeDao.save(terminalType);
        assertTrue(save);
    }

    @Test
    public void testUpdate() throws Exception {
        Object o = new Object();
        TerminalType terminalType = new TerminalType();
//        terminalType.setTerminalTypeId(o);
//        terminalType.setParentTypeId(o);
//        terminalType.setOsType(o);
//        terminalType.setScreenSizeEnumId(o);
//        terminalType.setDescription(o);
//        terminalType.setLastModifiedDate(o);
//        terminalType.setLastModifiedByUserLogin(o);
//        terminalType.setCreatedDate(o);
//        terminalType.setCreatedByUserLogin(o);
        boolean update = terminalTypeDao.update(terminalType);
        assertTrue(update);
    }

    @Test
    public void testDelete() throws Exception {
        boolean delete = terminalTypeDao.delete(1L);
        logger.info(delete + "~~~~~~~~~~~");
        assertTrue(delete);
    }
}