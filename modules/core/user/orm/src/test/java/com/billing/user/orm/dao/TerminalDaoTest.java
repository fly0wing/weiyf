package com.billing.user.orm.dao;

import com.billing.user.orm.model.Terminal;
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
public class TerminalDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(TerminalDaoTest.class);
    @Autowired
    TerminalDao terminalDao;

    @Test
    public void testGet() throws Exception {
        Terminal terminal = terminalDao.get(1L);
        logger.info(terminal.toString());
        assertNotNull(terminal);
    }

    @Test
    public void testSearch() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", "");
        params.put("fingerprint", "");
        params.put("defaultName", "");
        params.put("terminalTypeId", "");
        params.put("firstSessionId", "");
        params.put("firstActivateTimeBegin", "");
        params.put("firstActivateTimeEnd", "");
        List<Terminal> search = terminalDao.search(params);
        assertNotNull(search);
        assertTrue(!search.isEmpty());
        logger.info(Iterators.toString(search.iterator()));
    }

    @Test
    public void testSave() throws Exception {
        Object o = new Object();
        Terminal terminal = new Terminal();
//        terminal.setId(o);
//        terminal.setFingerprint(o);
//        terminal.setDefaultName(o);
//        terminal.setTerminalTypeId(o);
//        terminal.setFirstSessionId(o);
//        terminal.setFirstActivateTime(o);
        boolean save = terminalDao.save(terminal);
        assertTrue(save);
    }

    @Test
    public void testUpdate() throws Exception {
        Object o = new Object();
        Terminal terminal = new Terminal();
//        terminal.setId(o);
//        terminal.setFingerprint(o);
//        terminal.setDefaultName(o);
//        terminal.setTerminalTypeId(o);
//        terminal.setFirstSessionId(o);
//        terminal.setFirstActivateTime(o);
        boolean update = terminalDao.update(terminal);
        assertTrue(update);
    }

    @Test
    public void testDelete() throws Exception {
        boolean delete = terminalDao.delete(1L);
        logger.info(delete + "~~~~~~~~~~~");
        assertTrue(delete);
    }

    @Test
    public void testGetByFingerprint() {
        Object o = new Object();
//        Terminal terminal = terminalDao.getByFingerprint(o);
//        logger.info(terminal.toString());
//        assertNotNull(terminal);
    }
}