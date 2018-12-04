package com.bootdo.clouddocommon.handler;

import com.bootdo.clouddocommon.enums.GlobalEnum;
import com.bootdo.clouddocommon.utils.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {


    /*入参校验异常*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("必填校验异常: {}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return ResultVO.error(Integer.valueOf(GlobalEnum.PARAMETER_EXCEPTION.getCode()) , fieldError.getDefaultMessage());
    }


    /*入参校验异常*/
    @ExceptionHandler({BindException.class})
    public Object handleBindException(BindException ex ) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return ResultVO.error(Integer.valueOf(GlobalEnum.PARAMETER_EXCEPTION.getCode()) , fieldError.getDefaultMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    ResultVO runtimeException(RuntimeException e) {
        log.error("出现异常:" +e.getMessage());
        return ResultVO.error(Integer.valueOf(GlobalEnum.RUNTIMEEXCEPTION.getCode()), GlobalEnum.RUNTIMEEXCEPTION.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ResultVO exception(Exception e){
        log.error("未知异常 :" + e.getMessage());
        return ResultVO.error(Integer.valueOf(GlobalEnum.ERROE500.getCode()), e.getMessage());
    }
}
