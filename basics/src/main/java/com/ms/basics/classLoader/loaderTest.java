package com.ms.basics.classLoader;

/**
 * @author wangmingsen
 * @create 2018-09-11-15:18
 **/


public class loaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = loaderTest.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
       // Class<?> aClass = loader.loadClass("com.ms.basics.classLoader.Test2");
//        try {
//           Test2 test2 = (Test2) aClass.newInstance();
//
//            test2.start();
//            for(int i = 0; i< aClass.getMethods().length;i++){
//                System.out.println(aClass.getMethod("start",));
//            }
//
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        //使用Class.forName()来加载类，默认会执行初始化块
               // Class.forName("com.ms.basics.classLoader.Test2");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
                Class.forName("com.ms.basics.classLoader.Test2", false, loader);
    }
}
