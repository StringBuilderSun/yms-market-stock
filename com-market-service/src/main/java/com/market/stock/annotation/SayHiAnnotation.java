package com.market.stock.annotation;

import java.lang.annotation.*;

/**
 * Created by lijinpeng on 2018/5/23.
 */
//注解作用位置是方法 默认值是任何地方
@Target(ElementType.METHOD)
//定义该注解的生命周期  RUNTIME 始终保留
@Retention(RetentionPolicy.RUNTIME)
//将注解信息添加到java文档中
@Documented
public @interface SayHiAnnotation {
     String word() default "";
     String tag() default "";
}
