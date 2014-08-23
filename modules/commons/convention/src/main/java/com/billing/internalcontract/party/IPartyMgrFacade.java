package com.billing.internalcontract.party;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;

/**
 * 当事人管理接口
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IPartyMgrFacade {

    /**
     * 商户注册
     * @param req
     * @return
     */
    BaseResp partyRegister(PartyRegisterReq req);

    /**
     * 商户注册审核
     * @param req
     * @return
     */
    BaseResp partyRegisterAudit(BaseReq req);


}

