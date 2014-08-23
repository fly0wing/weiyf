package com.billing.internalcontract.product;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.party.PartyRegisterReq;

/**
 * 产品接口
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IProductFacade {

    /**
     * 创建产品
     * @param req
     * @return
     */
    BaseResp createProduct(CreateProductReq req);



}

