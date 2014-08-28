package com.billing.internalcontract.order;

import com.billing.internalcontract.BaseReq;
import com.billing.uom.Uom;

/**
 * 提交订单请求
 *  数量和时间均为0时，表示纯订阅检查。
 *  数量和时间不能同时大于0。
 *  数量大于0，表示需要扣数量。
 *  时间大于0，表示需要扣时间。
 *  如何扣？
 *  如果需要扣数量（匹配的先后顺序）：
 *      用户存在包时间的，先不扣数量
 *      存在
 *      
 * Created by xiaoyouyi on 2014-8-23.
 */
public class SubmitOrderReq extends BaseReq {

    /**
     * 商户订单标识
     */
    private String externalId;
    /**
     * 计费主体
     */
    private String billingPrincipalId;
    /**
     * 需要计费的产品标识。
     */
    private long productId;
    /**
     * 数量单位
     */
    private Uom quantityUom;
    /**
     * 使用数量：0表示数量无关
     */
    private int quantity;
    /**
     * 时间单位
     */
    private Uom timeUom;
    /**
     * 使用时间：0表示时间无关
     */
    private int time;


}
