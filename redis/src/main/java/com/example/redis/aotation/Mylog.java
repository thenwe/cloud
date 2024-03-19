package com.example.redis.aotation;

import java.lang.annotation.*;


@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Mylog {
    String value() default "renwei";
}

