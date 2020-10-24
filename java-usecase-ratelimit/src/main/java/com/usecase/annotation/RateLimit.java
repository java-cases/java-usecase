package com.usecase.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {

    /**
     * @return
     */
    String value() default "";

    /**
     * 每秒向桶中放入令牌的数量。
     * 默认最大，即不做限流。
     *
     * @return
     */
    double perSecond() default Double.MAX_VALUE;

    /**
     * 获取令牌的等待时间。
     * 默认0，即不等待。
     *
     * @return
     */
    int timeOut() default 0;

    /**
     * 令牌的等待时间单位。
     * 默认时间单位为MILLISECONDS。
     *
     * @return
     */
    TimeUnit timeOutUnit() default TimeUnit.MILLISECONDS;
}
