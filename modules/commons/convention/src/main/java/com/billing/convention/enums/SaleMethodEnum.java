package com.billing.convention.enums;

    /**
     * Created by xiaoyouyi on 2014-6-15.
     * * 按照销售方式类型划分：
     * 消费型_应用传入价格
     * 消费型_平台设置价格
     * 订阅型_按时长
     * 订阅型_按时长（自动续费）
     * 非消费型
     * 订阅型_按次数 SaleMethodEnum Subscription100,Managed200,Unmanaged300
     */
    public enum SaleMethodEnum {
        Subscription(100,"订阅型","完全由平台负责后续的商品使用" ),
        Subscription_ByCount(110, "订阅型_按次数",""),
        Subscription_ByCount_Monthly(111, "订阅型_按次数包月",""),
        Subscription_ByTime(120, "订阅型_按时长",""),
        Subscription_ByTime_Online(121, "订阅型_按时长在线",""),

        Managed(200,"托管型","平台要负责后续商品使用，应用发起委托平台扣减"),
        Managed_PriceByApp(210, "托管型_应用传入价格","无"),
        Managed_PriceAtMbp(220, "托管型_平台设置价格",""),

        Unmanaged(300,"消费型","类似电商的一般订单消费，一次性的，平台不负责后续商品使用"),
        Unmanaged_PriceByApp(310, "消费型_应用传入价格",""),
        Unmanaged_PriceAtMbp(320, "消费型_平台设置价格",""),

        Unknown(0, "未指定","未知的、全部的、不确定的");

        private final int code;

        public int getCode() {
            return code;
        }

        private final String name;

        private final String remark;

        public String getName() {
            return name;
        }

        private SaleMethodEnum(int code, String name, String remark) {
            this.code = code;
            this.name = name;
            this.remark=remark;
        }

        @Override
        public String toString() {
            return String.format("[%s]%s", code, name);
        }
        /**
         * 描述
         */
        public  String description;

    }
