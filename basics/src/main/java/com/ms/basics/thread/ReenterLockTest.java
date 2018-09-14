package com.ms.basics.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 练习ReenterLock
 * @author wangmingsen
 * @create 2018-09-14-14:04
 **/


public class ReenterLockTest implements Runnable {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static int j = 0;

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            reentrantLock.lock();
            reentrantLock.lock();
            try {
                j++;
            }finally {
                reentrantLock.unlock();
                reentrantLock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockTest reenterLockTest = new ReenterLockTest();

        Thread thread1 = new Thread(reenterLockTest);
        Thread thread2 = new Thread(reenterLockTest);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(j);

    }
}
