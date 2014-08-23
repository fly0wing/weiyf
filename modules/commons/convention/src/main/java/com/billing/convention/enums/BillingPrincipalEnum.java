package com.billing.convention.enums;

/**
 * Created by xiaoyouyi on 2014-6-15.
 * 计费主体枚举：
 * TerminalId	终端标识	终端硬件设备的散列值。自动绑定，不可转移，手机换了就不能用。
 * MobileNo	手机号	可以通过手机号来绑定或解绑设备，同时可以绑定多个。
 * PlatUserId	平台用户号	使用时，需要用户登录平台完成鉴权。
 * AppUserId	应用用户号	使用时，应用传递应用用户号即可。
 */
public enum BillingPrincipalEnum {
    Unknown(0, "未指定"),
    TerminalId(1, "终端标识"),
    MobileNo(2, "手机号"),
    PlatUserId(4, "平台用户号"),
    AppUserId(8, "应用用户号");

    private final int code;

    public int getCode() {
        return code;
    }

    private final String name;

    public String getName() {
        return name;
    }

    private BillingPrincipalEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[%s]%s", code, name);
    }
}
