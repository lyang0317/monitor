package cm.pharmaking.order.service.aop;

import cm.pharmaking.order.service.MethodMonitorHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class MethodAspect {

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(cm.pharmaking.order.common.annotation.MethodMonitor)")
    public void lockMethod(){}

    /**
     * 前置通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("lockMethod()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MethodMonitorHandler.handle();
    }

    /**
     * FINAL通知
     * @param joinPoint
     * @throws Throwable
     */
    @After("lockMethod()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        MethodMonitorHandler.handle();
    }

}
