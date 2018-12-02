package com.bootdo.clouddocommon.utils;

import com.bootdo.clouddocommon.enums.BaseEnum;
import com.bootdo.clouddocommon.enums.GlobalEnum;

import java.util.HashMap;
import java.util.Map;

public class ResultVO extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultVO() {
    }


    public ResultVO(BaseEnum baseEnum) {
        put("code",baseEnum.getCode());
        put("msg", baseEnum.getMessage());

    }
    public static ResultVO error() {
        return new ResultVO(GlobalEnum.ERROE500) ;
    }

    public static ResultVO operate(boolean b){
        if(b){
            return ResultVO.ok();
        }
        return ResultVO.error();
    }

    public static ResultVO error(String msg) {
        return error(GlobalEnum.ERROE500.getCode(), msg);
    }



    public static ResultVO error(String code, String msg) {
        ResultVO r = new ResultVO();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultVO ok(String msg) {
        ResultVO r = new ResultVO();
        r.put("msg", msg);
        return r;
    }

    public static ResultVO ok(Map<String, Object> map) {
        ResultVO r = new ResultVO();
        r.putAll(map);
        return r;
    }

    public static ResultVO ok() {
        ResultVO resultVO =  new ResultVO();
        resultVO.put("code" , GlobalEnum.SUCCESS.getCode());
        resultVO.put("msg" , GlobalEnum.SUCCESS.getMessage());
        return resultVO;
    }

    public static ResultVO ok( Object object) {
        ResultVO resultVO =  new ResultVO();
        resultVO.put("code" , GlobalEnum.SUCCESS.getCode());
        resultVO.put("msg" , GlobalEnum.SUCCESS.getMessage());
        resultVO.put("data" , object);
        return resultVO;
    }

    public static ResultVO result(BaseEnum baseEnum , Object object) {
        ResultVO resultVO =  new ResultVO();
        resultVO.put("code" ,baseEnum.getCode());
        resultVO.put("msg" , baseEnum.getMessage());
        resultVO.put("data" , object);
        return resultVO;
    }

    public static ResultVO error401( ) {
        return new ResultVO(GlobalEnum.ERROE401);
    }

    public static ResultVO error403() {
        return new ResultVO(GlobalEnum.ERROE403);
    }

    public static ResultVO data(Object data){
        return ResultVO.ok().put("data",data);
    }

    public static ResultVO page(Object page){
        return ResultVO.ok().put("page",page);
    }

    @Override
    public ResultVO put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
