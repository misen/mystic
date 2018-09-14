package com.ms.basics.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 死锁检查
 *
 * @author wangmingsen
 * @create 2018-09-14-14:21
 **/


public class DeadlockChecker {

    private final static ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
    final static Runnable deadlockCheck = () -> {
        while (true){
            long[] deadlockThreads = mxBean.findDeadlockedThreads();
            if (deadlockThreads != null){
                ThreadInfo[] threadInfos = mxBean.getThreadInfo(deadlockThreads);
                for(Thread thread : Thread.getAllStackTraces().keySet()){
                    for(int i= 0;i< threadInfos.length;i++){
                        if(thread.getId()==threadInfos[i].getThreadId()){
                            thread.interrupt();
                        }
                    }
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * 检查线程是否有死锁
     */
    public static void check(){
        Thread thread = new Thread(deadlockCheck);
        thread.setName("DeadlockChecker");
        thread.setDaemon(true);
        thread.start();
    }

    public static void main(String[] args) {
        DeadlockChecker.check();
    }
}
