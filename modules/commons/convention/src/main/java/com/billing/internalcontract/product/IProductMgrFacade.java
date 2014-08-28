package com.billing.internalcontract.product;

import com.billing.internalcontract.BaseResp;

/**
 * 产品管理接口
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IProductMgrFacade {

    /**
     * 创建产品
     * @param req
     * @return
     */
    BaseResp createProduct(CreateProductReq req);



}

