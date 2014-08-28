package com.billing.internalcontract.product;

import com.billing.internalcontract.BaseReq;

/**
 * 获取产品对应的商品
 * Created by xiaoyouyi on 2014-8-23.
 */
public class ProductGoodsReq extends BaseReq {
    /**
     * 需要计费的产品标识。
     */
    private long productId;
}
