package com.billing.product.orm.dao;

import com.billing.product.orm.model.Customer;
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
@ContextConfiguration(locations = {"classpath:applicationContext-private.xml","classpath:applicationContext-db-product.xml"})
@TransactionConfiguration(
        transactionManager = "", defaultRollback=true)
public class CustomerDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoTest.class);
    @Autowired
    CustomerDao customerDao;

    @Test
    public void testFindById() throws Exception {
        Customer byId = customerDao.findById(1L);

        assertNotNull(byId);
    }
}