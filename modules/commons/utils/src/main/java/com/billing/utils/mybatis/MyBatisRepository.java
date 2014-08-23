package com.billing.utils.mybatis;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by zhangkai on 2014/8/22.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisRepository {
    String value() default "";
}

