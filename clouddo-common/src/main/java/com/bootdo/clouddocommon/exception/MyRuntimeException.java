package com.bootdo.clouddocommon.exception;

import com.bootdo.clouddocommon.enums.BaseEnum;
import lombok.Getter;



/**
 *
 */
@Getter
public class MyRuntimeException extends RuntimeException {
    private String code;
    private String message;

    public MyRuntimeException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
        this.code = baseEnum.getCode();
    }

    public MyRuntimeException(String code, String message) {
        super(message);
        this.code = code;
    }


}