package com.billing.internalcontract.billing;

import com.billing.internalcontract.BaseReq;
import com.billing.uom.Uom;

import java.math.BigDecimal;

/**
 * 计费请求
 *  数量和时间均为0时，表示纯订阅检查。
 *  数量和时间不能同时大于0。
 *  数量大于0，表示需要扣数量。
 *  时间大于0，表示需要扣时间，之后在该时间范围内就不再重复扣。
 *  如何扣？
 *  如果需要扣数量（匹配的先后顺序）：
 *      用户存在包时间的，不扣数量
 *      先扣快过期的，
 *
 *  如果需要扣时间（匹配的先后顺序）：
 *      用户存在包时间的，不扣数量
 *      先扣快过期的，
 * Created by xiaoyouyi on 2014-8-23.
 */
public class BillingReq extends BaseReq {

    /**
     * 商户应用分区，可选，如果应用存在分区，用户可以自由选择分服分区时
     */
    private String cpAppArea;

    /**
     * 玩家在商户应用中的用户名，可选。如果产品身份认证是玩家账户时就是必须的。
     */
    private String cpUserName;

    /**
     * 需要计费的产品标识。必须的
     */
    private long productId;

    /**
     * 待计费资源地址，可选。在同一产品内，同一资源可重复计费的次数，默认为1次。
     */
    private String resourceUri;

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
