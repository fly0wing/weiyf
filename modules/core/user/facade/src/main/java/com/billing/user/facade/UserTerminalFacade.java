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
import com.billing.user.orm.dao.TerminalActivateDao;
import com.billing.user.orm.dao.TerminalDao;
import com.billing.user.orm.model.CustomerTerminal;
import com.billing.user.orm.model.Terminal;
import com.billing.user.orm.model.TerminalActivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户终端服务
 * Created by zkai on 2014/8/26.
 */
@Service
public class UserTerminalFacade implements IUserTerminalFacade {

    @Autowired
    private CustomerTerminalDao customerTermDao;

    @Autowired
    private TerminalDao terminalDao;

    @Autowired
    private TerminalActivateDao terminalActivateDao;

    UserSession userSession = null;

    /**
     * 绑定当前用户终端，无需传入待绑定的终端，从当前会话中获取。
     * @param baseReq 基本请求
     * @return 基本应答
     */
    @Override
    public BaseResp activeTerminal(BaseReq baseReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        /** Session检查 */
        if(null ==  userSession){
            return new BaseResp(true, UserConst.SESSION_ERROR, "SESSION失效");
        }

        Map<String,Object> params = new HashMap<>();
        params.put(TerminalActivate.FN_terminalId,userSession.getTerminalId());
        List<TerminalActivate> lstTermAct = terminalActivateDao.search(params);
        if(0 < lstTermAct.size()){
            return new BaseResp(true, UserConst.SUCCESS, "终端已激活");
        }
        TerminalActivate termActive = new TerminalActivate();
        termActive.setTerminalId(userSession.getTerminalId());
        termActive.setSessionId(userSession.getSessionId());
        termActive.setActivateTime(new Timestamp(System.currentTimeMillis()));
        terminalActivateDao.save(termActive);
        return new BaseResp(true, UserConst.SUCCESS, "终端激活成功");
    }


    /**
     * 绑定当前用户终端，无需传入待绑定的终端，从当前会话中获取。
     * @param terminalBindReq 终端绑定请求
     * @return 基本应答
     */
    @Override
    public BaseResp bindTerminal(TerminalBindReq terminalBindReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        /** Session检查 */
        if(null ==  userSession){
            return new BaseResp(true, UserConst.SESSION_ERROR, "SESSION失效");
        }
        /** 获取绑定终端列表 */
        List<CustomerTerminal> lstCustomerTerms =
                (List<CustomerTerminal>) getBoundTerminals(terminalBindReq).getObjResult();
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
            /** 已绑定终端，直接返回*/
            return new BaseResp(true,UserConst.SUCCESS,"该终端已绑定");
        }
        return new BaseResp(true,UserConst.SUCCESS,"终端绑定成功");
    }

    /**
     * 获取用户当前绑定的终端列表，主要是终端标识、指纹和名称信息
     * longReq传入CustomerId
     * @param baseReq 基本请求
     * @return 基本应答
     */
    public BaseResp getBoundTerminals(BaseReq baseReq) {
        BaseResp baseResp = new BaseResp<List<TerminalInfo>>(true);
        Map<String,Object> params = new HashMap<>();
        params.put(CustomerTerminal.FN_customerId,baseReq.getLongReq());
        List<TerminalInfo> lstCustomerTerms = customerTermDao.getBindTerms(params);
        baseResp.setObjResult(lstCustomerTerms);
        return baseResp;
    }

    /**
     * 解绑用户终端，输入需要待解除绑定的终端标识和指纹
     * @param terminalUnbindReq 终端解绑请求
     * @return 基本应答
     */
    @Override
    public BaseResp unbindTerminal(TerminalUnbindReq terminalUnbindReq) {
        userSession = (UserSession) WyfSecurityUtils.getSubject().getSession();
        /** Session检查*/
        if(null ==  userSession){
            return new BaseResp(true, UserConst.SESSION_ERROR, "SESSION失效");
        }
        /**检查该终端是否为绑定状态 */
        Map<String,Object> params = new HashMap<>();
        params.put(CustomerTerminal.FN_customerId, userSession.getCustomerId());
        params.put(CustomerTerminal.FN_terminalId, terminalUnbindReq.getTerminalId());
        params.put(CustomerTerminal.FN_bindStatus, true);
        List<CustomerTerminal> lstTerms = customerTermDao.search(params);
        if(0 > lstTerms.size()){
            /** 已解绑的终端，直接返回*/
            return new BaseResp(true, UserConst.SUCCESS, "该终端已解绑");
        }else{
            /** 绑定状态的终端，更新终端绑定状态*/
            lstTerms.get(0).setBindStatus(false);
            customerTermDao.update(lstTerms.get(0));
            return new BaseResp(true, UserConst.SUCCESS, "终端解绑成功");
        }
    }

    /**
     * 根据终端指纹获取终端
     * stringReq传入终端指纹
     * @param baseReq 基本请求
     * @return 基本应答
     */
    @Override
    public BaseResp getTerminalByFingerprint(BaseReq baseReq) {
        BaseResp<List<TerminalInfo>> baseResp = new BaseResp<>(true);
        Map<String,Object> params = new HashMap<>();
        params.put(Terminal.FN_fingerprint,baseReq.getStringReq());
        List<TerminalInfo> lstCustomerTerms = customerTermDao.getTermsByFingerPrint(params);
        baseResp.setObjResult(lstCustomerTerms);
        return baseResp;
    }
}
