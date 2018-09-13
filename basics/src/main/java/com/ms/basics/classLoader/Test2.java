package com.ms.basics.classLoader;

/**
 * @author wangmingsen
 * @create 2018-09-11-15:17
 **/


public class Test2 {

    Test2(){
        System.out.println("初始化");
    }
    static {
        System.out.println("静态初始化块执行了！");
    }

    public void start(){
        System.out.println("start....");
    }


    public static void main(String[] args) {

    }
}
