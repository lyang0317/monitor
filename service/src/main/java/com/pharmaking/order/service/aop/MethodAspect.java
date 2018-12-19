package com.pharmaking.order.service.aop;

import com.pharmaking.order.common.model.LogContext;
import com.pharmaking.order.service.WorkingPool;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class MethodAspect {

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.pharmaking.order.common.annotation.MethodMonitor)")
    public void methodMonitor(){}

    /**
     * 前置通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("methodMonitor()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        threadLocal.set(System.currentTimeMillis());
    }

    /**
     * FINAL通知
     * @param joinPoint
     * @throws Throwable
     */
    @After("methodMonitor()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        Long callTime = System.currentTimeMillis() - threadLocal.get();
        String className = joinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.toString();
        LogContext logContext = new LogContext();
        logContext.setMethodName(methodName);
        logContext.setCallTime(Integer.valueOf(String.valueOf(callTime)));
        WorkingPool.getWorkingQueue().add(logContext);
    }

}
