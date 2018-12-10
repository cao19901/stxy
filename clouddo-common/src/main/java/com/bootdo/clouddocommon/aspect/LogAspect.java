package com.bootdo.clouddocommon.aspect;

import com.bootdo.clouddocommon.annotation.Log;
import com.bootdo.clouddocommon.context.FilterContextHandler;
import com.bootdo.clouddocommon.dto.LogDO;
import com.bootdo.clouddocommon.service.LogRpcService;
import com.bootdo.clouddocommon.utils.HttpContextUtils;
import com.bootdo.clouddocommon.utils.IPUtils;
import com.bootdo.clouddocommon.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    LogRpcService logService;


    @Pointcut("@annotation(com.bootdo.clouddocommon.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();

        Object result = point.proceed();

        long time = System.currentTimeMillis() - beginTime;

        saveLog(point, time);
        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogDO sysLog = new LogDO();
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {

            sysLog.setOperation(syslog.value());
        }

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        Object[] args = joinPoint.getArgs();
        try {
            String params = JSONUtils.beanToJson(args[0]).substring(0, 4999);
            sysLog.setParams(params);
        } catch (Exception e) {

        }

        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        sysLog.setIp(IPUtils.getIpAddr(request));


        sysLog.setUserId(Long.parseLong(FilterContextHandler.getUserID() == null ? "000000" : FilterContextHandler.getUserID()));
        sysLog.setUsername(FilterContextHandler.getUsername() == null ? "" : FilterContextHandler.getUsername());
        sysLog.setTime((int) time);

        Date date = new Date();
        sysLog.setGmtCreate(date);

        logService.save(sysLog);
    }
}

