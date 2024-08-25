package com.example.redis.aop;

import com.example.redis.aotation.Mylog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class LogAop {

    @Pointcut("@annotation(com.example.redis.aotation.Mylog)")
    public void poingcut(){};

    @Around("poingcut()")
    public Object topoint(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        MethodSignature s=(MethodSignature)signature;
        System.out.println(signature+"进来了");
        Object[] i=point.getArgs();
        Object[] param={1};
        Object mg=point.getTarget();
        //获取标了注解的方法
        Method method = mg.getClass().getMethod(s.getName(), s.getParameterTypes());
        //获取注解
        Mylog annotation = method.getAnnotation(Mylog.class);
        System.out.println(annotation.value());
        for( Object j : i){
            System.out.println(j);
        }
        Object proceed = point.proceed(param);
        return proceed;
    }
}
