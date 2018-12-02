package com.bootdo.clouddocommon.enums;

import lombok.Getter;

@Getter
public enum CardOwnTypeEnum implements  BaseEnum {

    /**
     * 客户 icc 可关系状态
     */

    OWNER("0","自有"),
    PROXY("1","代理"),
    ;


    CardOwnTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;
}