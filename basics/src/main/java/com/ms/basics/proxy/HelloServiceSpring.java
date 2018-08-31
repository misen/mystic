package com.ms.basics.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangmingsen
 * @create 2018-08-22-10:25
 **/


public class HelloServiceSpring {

    public class HelloService {

        public void hello() {
            System.out.println("helloWorld!");
        }
    }
    //代理执行
    public static class Proxy implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("预处理");
            Object object =  methodProxy.invokeSuper(o,objects);
            System.out.println("后处理");
            return object;
        }
    }
    //测试
    public static void main(String[] args) {
        //代理类class文件dump存入本地磁盘
       // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\");

        //字节码增强器
        Enhancer enchancer = new Enhancer();
        //设置被代理类为父类
        enchancer.setSuperclass(HelloService.class);
        //设置回调
        enchancer.setCallback(new Proxy());
        HelloService helloService = (HelloService)enchancer.create();//创建代理实例
        helloService.hello();
    }
}
