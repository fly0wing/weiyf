package com.billing.user.orm.dao;

import com.billing.user.orm.model.TerminalActivate;
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
public class TerminalActivateDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(TerminalActivateDaoTest.class);
    @Autowired
    TerminalActivateDao terminalActivateDao;

    @Test
    public void testGet() throws Exception {
        TerminalActivate terminalActivate = terminalActivateDao.get(1L);
        logger.info(terminalActivate.toString());
        assertNotNull(terminalActivate);
    }

    @Test
    public void testSearch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", "");
        params.put("terminalId", "");
        params.put("sessionId", "");
        params.put("activateTimeBegin", "");
        params.put("activateTimeEnd", "");
        List<TerminalActivate> search = terminalActivateDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Test
    public void testSave() throws Exception {
        Object o = new Object();
        TerminalActivate terminalActivate = new TerminalActivate();
//        terminalActivate.setId(o);
//        terminalActivate.setTerminalId(o);
//        terminalActivate.setSessionId(o);
//        terminalActivate.setActivateTime(o);
        boolean save = terminalActivateDao.save(terminalActivate);
        assertTrue(save);
    }

    @Test
    public void testUpdate() throws Exception {
        Object o = new Object();
        TerminalActivate terminalActivate = new TerminalActivate();
//        terminalActivate.setId(o);
//        terminalActivate.setTerminalId(o);
//        terminalActivate.setSessionId(o);
//        terminalActivate.setActivateTime(o);
        boolean update = terminalActivateDao.update(terminalActivate);
        assertTrue(update);
    }

    @Test
    public void testDelete() throws Exception {
        boolean delete = terminalActivateDao.delete(1L);
        logger.info(delete + "~~~~~~~~~~~");
        assertTrue(delete);
    }
}