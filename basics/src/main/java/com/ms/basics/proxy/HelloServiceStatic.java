package com.ms.basics.proxy;

/**
 * 静态代理
 *
 * @author wangmingsen
 * @create 2018-08-22-9:14
 **/


//接口
public interface HelloServiceStatic {
    void hello();
}
//具体目标执行接口
class HelloServiceStaticImpl implements HelloServiceStatic{

    @Override
    public void hello(){
        System.out.println("hello");
    }
}
//代理类
class HelloServiceProxy implements HelloServiceStatic{

    private HelloServiceStatic helloServiceStatic = new HelloServiceStaticImpl();

    @Override
    public void hello (){
        System.out.println("执行前----");
        helloServiceStatic.hello();
        System.out.println("执行后----");
    }

    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        helloServiceProxy.hello();
    }
}