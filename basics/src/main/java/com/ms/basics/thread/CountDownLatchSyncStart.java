package com.ms.basics.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 多个线程同时启动
 * @author wangmingsen
 * @create 2018-09-13-16:51
 **/


public class CountDownLatchSyncStart {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {

        CountDownLatchSyncStart test = new CountDownLatchSyncStart();

        CountDownLatch latch = new CountDownLatch(1);


        Thread t1 = new Thread(test.new MapOper(latch));
        Thread t2 = new Thread(test.new MapOper(latch));
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();

        System.out.println("thread already start, sleep for a while...");

        Thread.sleep(1000);
        latch.countDown();

    }

    public class MapOper implements Runnable {

        CountDownLatch latch ;

        public MapOper(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" Sync Started!");
        }
    }

}
