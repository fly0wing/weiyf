package com.billing.internalcontract.billing;

import com.billing.convention.enums.SaleMethodEnum;
import com.billing.internalcontract.BaseResp;

/**
 * Created by xiaoyouyi on 2014-8-25.
 */
public class BillResp extends BaseResp {
    /**
     * 如果成功，是采用什么销售分式计费的。
     */
    private SaleMethodEnum saleMethod;


}
