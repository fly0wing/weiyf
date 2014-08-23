package com.billing.internalcontract;

/**
 * 行动令牌类型枚举：无，校验码，图片校验码，邮箱、短信
 * Created by xiaoyouyi on 2014-8-23.
 */
public enum ActionTokenEnum {
    None,
    Checksum,
    ImageChecksum,
    Email,
    Sms;
}
