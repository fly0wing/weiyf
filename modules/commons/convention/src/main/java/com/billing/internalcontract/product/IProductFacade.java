package com.billing.internalcontract.product;

import com.billing.internalcontract.BaseResp;

/**
 * 产品接口
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IProductFacade {

    /**
     * 获取产品对应的商品
     * @param req
     * @return
     */
    BaseResp getProductGoods(ProductGoodsReq req);



}

