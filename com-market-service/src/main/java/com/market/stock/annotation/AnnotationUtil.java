package com.market.stock.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * Created by lijinpeng on 2018/5/23.
 */
@Slf4j
public class AnnotationUtil {
    public static void getAnnotationService(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(SayHiAnnotation.class)) {
                SayHiAnnotation annotation = method.getAnnotation(SayHiAnnotation.class);
                log.info("你塞的word:{},tag:{}", annotation.word(), annotation.tag());
            }
        }
    }
}
