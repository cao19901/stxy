package com.bootdo.clouddocommon.enums;

import lombok.Getter;

@Getter
public enum  GlobalEnum implements  BaseEnum {

    /**
     *  负数 为 异常
     *
     */
    ERROE("-1", "异常"),
    SUCCESS("0","成功"),
    ERROE500("500","操作失败"),
    ERROE401("401","你还没有登录"),
    ERROE403("403","你没有访问权限"),
    ERROE901("901","导入读取文件异常"),
    RUNTIMEEXCEPTION("9999","哎呀!遇到错误,稍后重试"),
    PARAMETER_EXCEPTION("10001", "参数不正确"),
    UNKNOW_EXECPTION("19999","未处理异常")
    ;


    GlobalEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;
}