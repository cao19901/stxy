package com.bootdo.clouddocommon.utils;

import com.bootdo.clouddocommon.enums.BaseEnum;

import java.util.HashMap;
import java.util.Map;

public class ResultVO extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;


    public ResultVO() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static ResultVO error() {
        return error(500, "操作失败");
    }

    public static ResultVO operate(boolean b) {
        if (b) {
            return ResultVO.ok();
        }
        return ResultVO.error();
    }

    public static ResultVO error(String msg) {
        return error(500, msg);
    }

    public static ResultVO error(int code, String msg) {
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

    public static ResultVO result(BaseEnum baseEnum ,Object object) {
        ResultVO r = new ResultVO();
        r.put("code", Integer.valueOf(baseEnum.getCode()));
        r.put("msg", baseEnum.getMessage());
        r.put("data",object);
        return r;
    }

    public static ResultVO ok() {
        return new ResultVO();
    }

    public static ResultVO error401() {
        return error(401, "你还没有登录");
    }

    public static ResultVO error403() {
        return error(403, "你没有访问权限");
    }

    public static ResultVO data(Object data) {
        return ResultVO.ok().put("data", data);
    }

    public static ResultVO page(Object page) {
        return ResultVO.ok().put("page", page);
    }

    @Override
    public ResultVO put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
