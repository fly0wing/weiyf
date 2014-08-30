package com.billing.user.facade;

/**
 * 用户模块常量定义
 * Created by Xenox on 2014/8/29.
 */
public class UserConst {

    //用户模块基数
    public static final int UNIT_USER_FACADE = 1000;
    //成功
    public static final int SUCCESS = UNIT_USER_FACADE;
    //用户不存在
    public static final int USER_NOT_EXISTS = UNIT_USER_FACADE + 1;
    //客户端不存在
    public static final int TERM_NOT_EXISTS = UNIT_USER_FACADE + 2;
    //密码错误
    public static final int PASS_WRONG = UNIT_USER_FACADE + 3;
    //令牌错误
    public static final int TOKEN_WRONG = UNIT_USER_FACADE + 4;
    //注册失败
    public static final int REG_FAILED = UNIT_USER_FACADE + 5;
    //用户名已注册
    public static final int USER_ALREADY_EXISTS = UNIT_USER_FACADE + 6;
    //Email已注册
    public static final int EMAIL_ALREADY_EXISTS = UNIT_USER_FACADE + 7;
    //电话号码已注册
    public static final int PHONE_ALREADY_EXISTS = UNIT_USER_FACADE + 8;
    //密码更新失败
    public static final int PASS_UPD_FAILED = UNIT_USER_FACADE + 9;
    //输入验证码错误
    public static final int TOKEN_ERROR = UNIT_USER_FACADE + 10;
    //参数错误
    public static final int PARAM_ERROR = UNIT_USER_FACADE + 11;
    //SESSION失效
    public static final int SESSION_ERROR = UNIT_USER_FACADE + 12;
    //终端激活失败
    public static final int TERM_ACTIVE_ERROR = UNIT_USER_FACADE + 13;
    //终端绑定失败
    public static final int TERM_BIND_ERROR = UNIT_USER_FACADE + 14;
    //终端解绑失败
    public static final long TERM_UNBIND_ERROR = UNIT_USER_FACADE + 15;

    //安全级别：匿名
    public static final int REG_ANONYMOUS = 0;
    //安全级别：用户名绑定
    public static final int REG_LOGIN_NAME = 1;
    //安全级别：Email绑定
    public static final int REG_EMAIL = 2;
    //安全级别：电话号码绑定
    public static final int REG_PHONE = 4;

    // 0
    public static final char ZERO = '0';
    // a
    public static final char A_LOWER = 'a';
    // A
    public static final char A_UPPER = 'A';

    public static final String MSG_SESSION_ERROR = "SESSION失效";

    public static final String MSG_PARAM_ERROR = "输入参数错误";

    public static final String MSG_USER_NOT_EXISTS = "用户不存在";

    public static final String MSG_USER_ALREADY_EXISTS = "用户名已注册";

    public static final String MSG_REG_FAILED = "注册失败";

    public static final String MSG_TOKEN_ERROR = "令牌错误";

    public static final String MSG_PHONE_ALREADY_EXISTS = "电话号码已注册";

    public static final String MSG_PASS_WRONG = "密码错误";

    public static final String MSG_PASS_UPD_FAILED = "密码更新失败";

    public static final String MSG_TERM_ACTIVE_ERROR = "终端激活失败";

    public static final String MSG_TERM_BIND_ERROR = "终端绑定失败";

    public static final String MSG_TERM_UNBIND_ERROR = "终端解绑失败";

    public static final String MSG_SUCCESS = "成功";

    public static final String MSG_TERM_NOT_EXISTS = "客户端不存在";

    public static final String MSG_EMAIL_ALREADY_EXISTS = "Email已注册";
}
