package com.billing.user.facade;

/**
 * Created by Xenox on 2014/8/29.
 */
public class UserConst {

    //用户模块基数
    public final static int UNIT_USER_FACADE = 1000;
    //成功
    public final static int SUCCESS = UNIT_USER_FACADE + 0;
    //用户不存在
    public final static int USER_NOT_EXISTS = UNIT_USER_FACADE + 1;
    //客户端不存在
    public final static int TERM_NOT_EXISTS = UNIT_USER_FACADE + 2;
    //密码错误
    public final static int PASS_WRONG = UNIT_USER_FACADE + 3;
    //令牌错误
    public final static int TOKEN_WRONG = UNIT_USER_FACADE + 4;
    //注册失败
    public final static int REG_FAILED = UNIT_USER_FACADE + 5;
    //用户名已注册
    public final static int USER_ALREADY_EXISTS = UNIT_USER_FACADE + 6;
    //Email已注册
    public final static int EMAIL_ALREADY_EXISTS = UNIT_USER_FACADE + 7;
    //电话号码已注册
    public final static int PHONE_ALREADY_EXISTS = UNIT_USER_FACADE + 8;
    //密码更新失败
    public final static int PASS_UPD_FAILED = UNIT_USER_FACADE + 9;
    //输入验证码错误
    public final static int TOKEN_ERROR = UNIT_USER_FACADE + 10;
    //参数错误
    public final static int PARAM_ERROR = UNIT_USER_FACADE + 11;
    //SESSION失效
    public final static int SESSION_ERROR = UNIT_USER_FACADE + 12;

    //安全级别：匿名
    public final static int REG_ANONYMOUS = 0;
    //安全级别：用户名绑定
    public final static int REG_LOGIN_NAME = 1;
    //安全级别：Email绑定
    public final static int REG_EMAIL = 2;
    //安全级别：电话号码绑定
    public final static int REG_PHONE = 4;

    // 0
    public final static char ZERO = '0';
    // a
    public final static char A_LOWER = 'a';
    // A
    public final static char A_UPPER = 'A';
}
