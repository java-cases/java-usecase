package javax.lang.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityExt {
    String name() default "";
    String key() default "";
}
