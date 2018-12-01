package com.lifesunny.common.annotation;

import java.lang.annotation.*;

/**
 * Description: 系统日志注解
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}