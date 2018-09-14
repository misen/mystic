package com.ms.basics.thread;

import java.util.concurrent.*;

/**
 * 线程池的练习
 * @author wangmingsen
 * @create 2018-09-10-15:18
 **/


public class MyCachedThreadPool {

    public static int size;
    public synchronized static int size(){
        return size ++;
    }

    public static void main(String[] args) {



        Runnable runnable = () -> {
            size();
            System.out.println(size+"------"+Thread.currentThread().getName()+"----runing...");

            try {
                Thread.sleep(1000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(size+"------"+Thread.currentThread().getName()+"----end...");

        };



//执行前用于保持任务的队列5，即任务缓存队列
        final  ArrayBlockingQueue<Runnable> workQueue =new ArrayBlockingQueue<>(5);


        //构建一个线程池，正常线程数量为5，最大线程数据为10，等待时间200
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, 5, 2, TimeUnit.MINUTES,	workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0;i<7;i++) {
            threadPoolExecutor.execute(runnable);


            System.out.println("线程池中现在的线程数目是："+threadPoolExecutor.getPoolSize()+",  队列中正在等待执行的任务数量为："+
                    threadPoolExecutor.getQueue().size());

        }
        threadPoolExecutor.shutdown();


    }
}
