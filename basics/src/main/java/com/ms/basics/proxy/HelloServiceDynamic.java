package com.ms.basics.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author wangmingsen
 * @create 2018-08-22-9:18
 **/


public class HelloServiceDynamic {
    //目标接口
    public interface HelloWorld {
        void print();
    }
    //目标类
    public static class HelloWorldImpl implements HelloWorld {
        @Override
        public void print() {
            System.out.println("HelloWorld-------------");
        }
    }
    //代理执行处理器
    public static class HelloInvocationHandler implements InvocationHandler {
        private Object obj;

        public HelloInvocationHandler(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Before Hello World!");
            Object res = null;
            try{
                res = method.invoke(obj, new Object[]{});
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("After Hello World!");
            return res;
        }
    }
    //测试
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorldImpl();
        HelloInvocationHandler helloInvocationHandler = new HelloInvocationHandler(helloWorld);
        HelloWorld target = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), helloInvocationHandler);
        target.print();

        //下面是将代理类class文件dump下来的操作
        byte[] classFile = ProxyGenerator.generateProxyClass("*Proxy0", HelloWorldImpl.class.getInterfaces());
        String path = "/Proxy0_HelloWorld.class";

        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}
