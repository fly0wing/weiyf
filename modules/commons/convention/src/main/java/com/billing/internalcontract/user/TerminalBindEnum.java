package com.billing.internalcontract.user;

/**
 * 终端绑定和解绑的类型：匿名的、注册时、用户主动、客服后台操作
 * Created by xiaoyouyi on 2014-8-23.
 */
public enum TerminalBindEnum {
    Anonymous,
    Register,
    UserManual,
    BackOffice;
}
