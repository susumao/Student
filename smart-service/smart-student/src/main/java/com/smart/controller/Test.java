package com.smart.controller;

import java.lang.annotation.*;

public class Test {
    @MyAnnotation
    public void test(){

    }
}

//定义这个注解能用在什么地方(方法上或类上等等)
@Target(value = ElementType.METHOD)
//定义这个注解在什么状态还有效(源码,字节码,运行时)
@Retention(value = RetentionPolicy.RUNTIME)
//定义这个注解生成在javaDoc文档中
@Documented
//子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}