package com.billing.internalcontract.billing;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;

/**
 * 计费接口
 * Created by xiaoyouyi on 2014-8-25.
 */
public interface IBillingFacade {

    /**
     * 计费
     * 如果用户之前没有购买或不满足使用条件，则需要在SDK中引导用户下单
     * @param req
     * @return
     */
    BaseResp billing(BillingReq req);


    /**
     * 获取用户特定产品的购买情况
     * @param req
     * @return
     */
    BaseResp getCustomerGoods(BillingReq req);
}
