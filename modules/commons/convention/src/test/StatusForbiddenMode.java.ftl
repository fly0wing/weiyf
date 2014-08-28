package com.billing.convention.enums;

/**
 * Created by xiaoyouyi on 2014-8-22.
 * 状态禁止模式
 */
public enum StatusForbiddenMode {
    ListFull(1,"列举全部",1),
    ListForbidden(2,"列举禁止的",2),
    ListAllowed(3,"列举允许的",3);

    StatusForbiddenMode(int code,String desc,int id){
        this.code=code;
        this.desc=desc;
        this.id=id;
    }
    public final int code;
    public final String desc;
    public final int id;

    public static StatusForbiddenMode getByCode(int code ){
        switch(code) {
            case 1:
                return StatusForbiddenMode.ListFull;
            case 2:
                return StatusForbiddenMode.ListForbidden;
            case 3:
                return StatusForbiddenMode.ListAllowed;
        }
        throw new IllegalArgumentException( "状态禁止模式,无效的Code" + code);
    }

    public static StatusForbiddenMode getById(int id ){
        switch(id) {
            case 1:
                return StatusForbiddenMode.ListFull;
            case 2:
                return StatusForbiddenMode.ListForbidden;
            case 3:
                return StatusForbiddenMode.ListAllowed;
        }
        throw new IllegalArgumentException( "状态禁止模式,无效的Id" + id);
    }
}
