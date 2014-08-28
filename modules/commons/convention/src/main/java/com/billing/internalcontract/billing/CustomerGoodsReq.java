package com.billing.internalcontract.billing;

import com.billing.internalcontract.BaseReq;
import com.billing.uom.Uom;

/**
 * 获取用户拥有的商品请求
 * Created by xiaoyouyi on 2014-8-23.
 */
public class CustomerGoodsReq extends BaseReq {

    /**
     * 商户应用分区，可选，如果应用存在分区，用户可以自由选择分服分区时
     */
    private String cpAppArea;

    /**
     * 玩家在商户应用中的用户名，可选。如果产品身份认证是玩家账户时就是必须的。
     */
    private String cpUserName;

    /**
     * 需要查询的产品标识。为0表示不限某特定产品。
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
