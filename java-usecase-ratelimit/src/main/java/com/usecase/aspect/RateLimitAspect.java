package com.usecase.aspect;

import com.google.common.util.concurrent.RateLimiter;
import com.usecase.annotation.RateLimit;
import com.usecase.exception.RateLimitException;
import com.usecase.status.RestStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

@Aspect
@Component
public class RateLimitAspect {
    private final static Logger logger = LoggerFactory.getLogger(RateLimitAspect.class);

    private final RateLimiter rateLimiter = RateLimiter.create(Double.MAX_VALUE);

    /**
     * 定义切点，带有指定RateLimit注解切入。
     */
    @Pointcut("@annotation(com.usecase.annotation.RateLimit)")
    public void checkRateLimitAnnotation() {
    }

    @ResponseBody
    @Around(value = "checkRateLimitAnnotation()")
    public Object aroundRateLimitAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(String.format("限流拦截{}方法...", joinPoint.getSignature().getName()));

        Method targetMethod = getTargetMethod(joinPoint);
        if (!targetMethod.isAnnotationPresent(RateLimit.class)) {
            return joinPoint.proceed(); //如果没有RateLimit注解，继续调用方法
        }

        //获取目标方法的RateLimit注解
        RateLimit rateLimit = targetMethod.getAnnotation(RateLimit.class);
        rateLimiter.setRate(rateLimit.perSecond());

        if (!rateLimiter.tryAcquire(rateLimit.timeOut(), rateLimit.timeOutUnit())) {
            RestStatus status = RestStatus.builder()
                    .message("服务器繁忙，请稍后再试!")
                    .errorCode("PM.001.002")
                    .statusCode(HttpStatus.TOO_MANY_REQUESTS)
                    .build();

            throw new RateLimitException(status);
        }

        return joinPoint.proceed();
    }

    private Method getTargetMethod(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        //获取目标方法
        return methodSignature.getMethod();
    }
}
