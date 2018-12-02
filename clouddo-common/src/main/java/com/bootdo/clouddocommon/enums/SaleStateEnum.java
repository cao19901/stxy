package com.bootdo.clouddocommon.enums;

import lombok.Getter;

@Getter
public enum SaleStateEnum implements  BaseEnum {

    /**
     *
     *icc card 状态枚举类
     */

    UNBIND("0","未绑定"),
    SALING("1","待售"),
    SALED("2","已出售")
    ;


    SaleStateEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;
}