package com.billing.internalcontract.product;

import com.billing.internalcontract.BaseReq;

import java.util.List;

/**
 * 产品对应的商品应答
 * Created by xiaoyouyi on 2014-8-23.
 */
public class ProductGoodsResq extends BaseReq {
    /**
     * 需要计费的产品标识。
     */
    private long productId;

    private List<Goods> goodsList;
}
