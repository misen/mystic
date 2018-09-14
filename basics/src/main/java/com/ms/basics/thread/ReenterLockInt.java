package com.ms.basics.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟死锁
 *
 * @author wangmingsen
 * @create 2018-09-14-15:26
 **/


public class ReenterLockInt implements Runnable {


    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public ReenterLockInt(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();

                Thread.sleep(500);
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();

                Thread.sleep(500);

                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }

            System.out.println(Thread.currentThread().getId()+"线程退出");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReenterLockInt reenterLockInt1 = new ReenterLockInt(1);
        ReenterLockInt reenterLockInt2 = new ReenterLockInt(1);

        Thread thread1 = new Thread(reenterLockInt1);
        Thread thread2 = new Thread(reenterLockInt2);
        thread1.start();
        thread2.start();

        Thread.sleep(1000);
//        DeadlockChecker.check();
    }
}
