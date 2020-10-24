package com.usecase.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TraceLogMethodAspect {

    private static final Logger log = LoggerFactory.getLogger(TraceLogMethodAspect.class);

    //匹配连接点的方法是否有某个注解
    @Pointcut("@annotation(com.usecase.annotation.TraceLogMethod)")
    public void annotationWithMethodCut() {
    }

    private String getJoinPointInfo(JoinPoint joinPoint) {
        return joinPoint.getSignature() + ", Args:" + Arrays.toString(joinPoint.getArgs());
    }

    @Before("annotationWithMethodCut()")
    public void beforeLog(JoinPoint joinPoint) {
        log.info("TraceLogMethod Before: " + getJoinPointInfo(joinPoint));
    }

    @After("annotationWithMethodCut()")
    public void afterLog(JoinPoint joinPoint) {
        log.info("TraceLogMethod After: " + getJoinPointInfo(joinPoint));
    }

    @AfterThrowing("annotationWithMethodCut()")
    public void afterThrowingLog(JoinPoint joinPoint) {
        log.error("TraceLogMethod AfterThrowing: " + getJoinPointInfo(joinPoint));
    }

    @AfterReturning("annotationWithMethodCut()")
    public void afterReturningLog(JoinPoint joinPoint) {
        log.info("TraceLogMethod AfterReturning: " + getJoinPointInfo(joinPoint));
    }
}
