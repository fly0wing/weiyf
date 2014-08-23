package com.billing.internalcontract.app;

import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.party.PartyRegisterReq;

/**
 * 应用管理接口
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IAppMgrFacade {

    /**
     * 创建应用
     * @param req
     * @return
     */
    BaseResp createApp(PartyRegisterReq req);

}

