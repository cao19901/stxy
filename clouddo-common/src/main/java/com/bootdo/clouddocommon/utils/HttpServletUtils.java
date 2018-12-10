package com.bootdo.clouddocommon.utils;

import javax.servlet.http.HttpServletRequest;

public class HttpServletUtils {
    /**
     * 判断是否是ajax 请求
     * @param req
     * @return
     */
    public static boolean jsAjax(HttpServletRequest req){

        boolean isAjaxRequest = false;
        if(!StringUtils.isBlank(req.getHeader("x-requested-with")) && req.getHeader("x-requested-with").equals("XMLHttpRequest")){
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }





}
