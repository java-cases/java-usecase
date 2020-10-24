package com.usecase.lang.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)// 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。
@Documented
public @interface Column {
    String name() default "";

    ColumnType type() default ColumnType.VARCHAR;

    boolean nullable() default true;

    boolean autoIncrement() default false;
}
