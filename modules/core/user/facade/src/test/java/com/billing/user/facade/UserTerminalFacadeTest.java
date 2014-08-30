package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.user.TerminalBindEnum;
import com.billing.internalcontract.user.TerminalBindReq;
import com.billing.internalcontract.user.TerminalUnbindReq;
import com.billing.user.facade.shiro.WyfSecurityUtils;
import com.billing.user.orm.business_model.TerminalInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath:applicationContext-facade.xml"})
@TransactionConfiguration(
        transactionManager = "userTransactionManager", defaultRollback = true)
@Transactional
@Service
public class UserTerminalFacadeTest {

    private static final Logger logger = LoggerFactory.getLogger(UserTerminalFacadeTest.class);

    @Autowired
    private UserTerminalFacade userFacade;

    private final static String fingerprint = "abcabcabcabcabcabcabcabca";

    @Test
    public void testActiveTerminal() throws Exception {

    }

    @Test
    public void testBindTerminal() throws Exception {
        TerminalBindReq terminalBindReq = new TerminalBindReq();
        terminalBindReq.setTerminalBindType(TerminalBindEnum.Anonymous);
        terminalBindReq.setTerminalName("我的终端1");
        terminalBindReq.setAuto(false);
        BaseResp baseResp = userFacade.bindTerminal(terminalBindReq);
        assertTrue(baseResp.isNormal());
        assertTrue(baseResp.isOK());
    }

    @Test
    public void testGetBoundTerminals() throws Exception {
        // 没有绑定的状态.
        BaseReq baseReq = new BaseReq();
        baseReq.setLongReq(1111);// 客户id.

        BaseResp<List<TerminalInfo>> boundTerminals = userFacade.getBoundTerminals(baseReq);
        List<TerminalInfo> objResult = boundTerminals.getObjResult();

        assertTrue(boundTerminals.isNormal());
        assertTrue(boundTerminals.isOK());
        assertTrue(objResult.isEmpty());

        // todo 绑定的状态
    }

    @Test
    public void testUnbindTerminal() throws Exception {
        TerminalUnbindReq terminalUnbindReq = new TerminalUnbindReq();
        terminalUnbindReq.setTerminalBindType(TerminalBindEnum.Anonymous);
        terminalUnbindReq.setFingerprint(fingerprint);
        terminalUnbindReq.setTerminalId(1);


        BaseResp baseResp = userFacade.unbindTerminal(terminalUnbindReq);

        assertTrue(baseResp.isNormal());
        assertTrue(baseResp.isOK());
    }

    @Test
    public void testGetTerminalByFingerprint() throws Exception {
        BaseReq baseReq = new BaseReq();
        baseReq.setStringReq(fingerprint);
        BaseResp<List<TerminalInfo>> baseResp = userFacade.getTerminalByFingerprint(baseReq);

        assertTrue(baseResp.isNormal());
        assertTrue(baseResp.isOK());
    }
}