package com.smart.Test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        DateTime dateTime = DateUtil.beginOfDay(new Date());
        System.out.println(dateTime);
    }

}


class A {

    static {
        System.out.println("A静态代码块");
        m = 300;
    }

    static int m = 100;

    public A (){
        System.out.println("A无参构造法");
    }
}