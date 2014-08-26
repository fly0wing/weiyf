package ${basePackage}.dao;

<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
import ${basePackage}.model.${className};
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
// @TransactionConfiguration(
//        transactionManager = "", defaultRollback=true)
public class ${className}DaoTest {

    private static final Logger logger = LoggerFactory.getLogger(${className}DaoTest.class);
    @Autowired
    ${className}Dao ${classNameLower}Dao;

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
<#list table.columns as column>
    <#if column.unique && !column.pk>
    @Test
    public void testGetBy${column.columnName}() {
        assertNotNull(null);
    }
    </#if>

</#list>
}