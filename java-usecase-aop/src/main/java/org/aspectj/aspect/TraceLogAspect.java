package org.aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TraceLogAspect {

    private static final Logger log = LoggerFactory.getLogger(TraceLogAspect.class);

    //匹配连接点的方法是否有某个注解
    @Pointcut("@annotation(org.aspectj.annotation.TraceLog)")
    public void anyTraceLogAnnotationCut() {
    }

    private String getJoinPointInfo(JoinPoint joinPoint) {
        return joinPoint.getSignature() + ", Args:" + Arrays.toString(joinPoint.getArgs());
    }

    @Before("anyTraceLogAnnotationCut()")
    public void beforeLog(JoinPoint joinPoint) {
        log.info("TraceLog Before: " + getJoinPointInfo(joinPoint));
    }

    @After("anyTraceLogAnnotationCut()")
    public void afterLog(JoinPoint joinPoint) {
        log.info("TraceLog After: " + getJoinPointInfo(joinPoint));
    }

    @AfterThrowing("anyTraceLogAnnotationCut()")
    public void afterThrowingLog(JoinPoint joinPoint) {
        log.error("TraceLog AfterThrowing: " + getJoinPointInfo(joinPoint));
    }

    @AfterReturning("anyTraceLogAnnotationCut()")
    public void afterReturningLog(JoinPoint joinPoint) {
        log.info("TraceLog AfterReturning: " + getJoinPointInfo(joinPoint));
    }
}
