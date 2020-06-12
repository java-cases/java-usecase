package com.usecase.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class DepartmentAspect {

    private static final Logger log = LoggerFactory.getLogger(DepartmentAspect.class);

    //匹配方法执行连接点，即匹配哪个方法执行
    @Pointcut("execution(public com.usecase.domain.Employee com.usecase.department.DepartmentService.getEmployee(Integer))")
    public void findEmployeeCut() {
    }

    //第一个宽字符 * 匹配 任何返回类型，
    //第二个宽字符 * 匹配 任何方法名，
    //最后的参数 (..) 表达式匹配任意数量任意类型的参数，
    //也就是说该切点会匹配类中所有方法的调用。
    @Pointcut("execution(* com.usecase.department.DepartmentService.*(..))")
    public void anyMethodCut() {
    }

    //匹配具体的方法参数
    //匹配任何以 find 开头并且只有一个 Integer 类型的参数的方法。
    @Pointcut("execution(* *..get*(Integer))")
    public void matchedMethodCut() {
    }

    //匹配一个以 Integer 类型开始的参数，后面的参数类型不做限制
    @Pointcut("execution(* *..get*(Integer,..))")
    public void matchedMethodWithMultiArgsCut() {
    }

    @Pointcut("matchedMethodCut() && matchedMethodWithMultiArgsCut()")
    public void combinedPointcuts() {
    }

    //匹配一个类中所有方法的调用
    @Pointcut("within(com.usecase.department.DepartmentService)")
    public void anyMethodWithinClassCut() {
    }

    //匹配某个包下面的所有类的所有方法调用
    @Pointcut("within(com.usecase.department.*)")
    public void anyMethodWithinPackageCut() {
    }

    private String getJoinPointInfo(JoinPoint joinPoint) {
        return joinPoint.getSignature() + ", Args:" + Arrays.toString(joinPoint.getArgs());
    }

    @Before("findEmployeeCut()")
    public void beforeLog(JoinPoint joinPoint) {
        log.info("Before: " + getJoinPointInfo(joinPoint));
    }

    @After("findEmployeeCut()")
    public void afterLog(JoinPoint joinPoint) {
        log.info("After: " + getJoinPointInfo(joinPoint));
    }

    @AfterThrowing("findEmployeeCut()")
    public void afterThrowingLog(JoinPoint joinPoint) {
        log.error("AfterThrowing: " + getJoinPointInfo(joinPoint));
    }

    @AfterReturning("findEmployeeCut()")
    public void afterReturningLog(JoinPoint joinPoint) {
        log.info("AfterReturning: " + getJoinPointInfo(joinPoint));
    }


}
