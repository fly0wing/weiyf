package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.UserSession;
import com.billing.internalcontract.user.IUserTerminalFacade;
import com.billing.internalcontract.user.TerminalBindReq;
import com.billing.internalcontract.user.TerminalUnbindReq;
import com.billing.user.facade.shiro.WyfSecurityUtils;
import com.billing.user.orm.business_model.TerminalInfo;
import com.billing.user.orm.dao.CustomerTerminalDao;
import com.billing.user.orm.dao.TerminalDao;
import com.billing.user.orm.model.CustomerTerminal;
import com.billing.user.orm.model.Terminal;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zkai on 2014/8/26.
 */
public class UserTerminalFacade implements IUserTerminalFacade {

    @Autowired
    private CustomerTerminalDao customerTermDao;

    @Autowired
    private TerminalDao terminalDao;

    UserSession userSession = null;

    @Override
    public BaseResp activeTerminal(BaseReq req) {
        return null;
    }


    /**
     * 绑定当前用户终端，无需传入待绑定的终端，从当前会话中获取。
     * @param terminalBindReq
     * @return
     */
    @Override
    public BaseResp bindTerminal(TerminalBindReq terminalBindReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        if(null ==  userSession){
            return new BaseResp(true, UserConst.SESSION_ERROR, "SESSION失效");
        }
        /** 获取绑定终端列表 */
        List<CustomerTerminal> lstCustomerTerms = (List<CustomerTerminal>) getBoundTerminals(terminalBindReq).getObjResult();
        boolean bFlg = false;
        for (CustomerTerminal customerTerminal : lstCustomerTerms) {
            if (userSession.getTerminalId() == customerTerminal.getTerminalId()) {
                bFlg = true;
                break;
            }
        }
        /** 未绑定终端*/
        if (!bFlg) {
            lstCustomerTerms.clear();
            Map<String, Object> params = new HashMap<>();
            params.put(CustomerTerminal.FN_customerId, userSession.getCustomerId());
            params.put(CustomerTerminal.FN_terminalId, userSession.getTerminalId());
            lstCustomerTerms = customerTermDao.search(params);
            /** 该终端从未绑定过*/
            if (0 == lstCustomerTerms.size()) {
                /** 获取默认终端名*/
                CustomerTerminal customerTerm = new CustomerTerminal();
                params.clear();
                params.put(Terminal.FN_fingerprint, userSession.getFingerprint());
                List<Terminal> lstTerms = terminalDao.search(params);
                params.clear();
                if (0 == lstTerms.size()) {
                    customerTerm.setTerminalName(terminalBindReq.getTerminalName());
                } else {
                    customerTerm.setTerminalName(lstTerms.get(0).getDefaultName());
                }
                customerTerm.setCustomerId(userSession.getCustomerId());
                customerTerm.setTerminalId(userSession.getTerminalId());
                customerTerm.setBindStatus(true);
                customerTerm.setCurrentOpTime(new Timestamp(System.currentTimeMillis()));
                customerTerm.setLastOpTime( new Timestamp(System.currentTimeMillis()));
                customerTerm.setFirstBindTime(new Timestamp(System.currentTimeMillis()));
                customerTerm.setIsAutoLogin(terminalBindReq.isAuto());
                //TODO:lastLoginToken
//                customerTerm.setLastLoginToken(terminalBindReq.getActionToken());
                /** 插入用户终端信息*/
                customerTermDao.save(customerTerm);
            } else {
                /** 该终端为解绑状态 */
                CustomerTerminal updCustomerTerm = lstCustomerTerms.get(0);
                updCustomerTerm.setBindStatus(true);
                /** 更新用户终端绑定状态 */
                customerTermDao.update(updCustomerTerm);
            }
        }else{
            return new BaseResp(true,UserConst.SUCCESS,"该终端已绑定");
        }
        return new BaseResp(true,UserConst.SUCCESS,"终端绑定成功");
    }

    /**
     * 获取用户当前绑定的终端列表，主要是终端标识、指纹和名称信息
     * longReq传入CustomerId
     * @param baseReq
     * @return
     */
    public BaseResp getBoundTerminals(BaseReq baseReq) {
        BaseResp baseResp = new BaseResp(true);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(CustomerTerminal.FN_customerId,baseReq.getLongReq());
        List<TerminalInfo> lstCustomerTerms = customerTermDao.getBindTerms(params);
        baseResp.setObjResult(lstCustomerTerms);
        return baseResp;
    }

    @Override
    public BaseResp unbindTerminal(TerminalUnbindReq terminalUnbindReq) {
        return null;
    }

    /**
     * 根据终端指纹获取终端
     * longReq传入终端指纹
     * @param baseReq
     * @return
     */
    @Override
    public BaseResp getTerminalByFingerprint(BaseReq baseReq) {
        BaseResp baseResp = new BaseResp(true);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(Terminal.FN_fingerprint,baseReq.getLongReq());
        List<TerminalInfo> lstCustomerTerms = customerTermDao.getTermsByFingerPrint(params);
        baseResp.setObjResult(lstCustomerTerms);
        return baseResp;
    }
}
