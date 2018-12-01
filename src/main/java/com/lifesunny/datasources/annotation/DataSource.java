package com.lifesunny.datasources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
