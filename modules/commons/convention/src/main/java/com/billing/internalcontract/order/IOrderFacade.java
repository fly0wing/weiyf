package com.billing.internalcontract.order;

import com.billing.internalcontract.BaseResp;

/**
 * 订单接口
 * Created by xiaoyouyi on 2014-8-25.
 */
public interface IOrderFacade {

    /**
     * 提交订单
     * @param req
     * @return
     */
    BaseResp submitOrder(SubmitOrderReq req);
}
