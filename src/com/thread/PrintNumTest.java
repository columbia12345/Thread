package com.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintNumTest {
    public static void main(String[] args) {
        new Thread(new PrintA()).start();
        Thread b = new Thread(new PrintB());
        Thread num = new Thread(new PrintNum());
        b.setPriority(Thread.MAX_PRIORITY); //10
        num.setPriority(Thread.MIN_PRIORITY); //1
        b.setDaemon(true);//将b线程设置为守护线程
        //守护线程是其他所有线程的保姆，只有其他所有线程都执行完毕后
        //守护线程才会结束自身的执行
        b.start();
        num.start();

        //线程池，加快线程的启动速度（三个及以上）
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new PrintA());
        executor.execute(new PrintB());
        executor.execute(new PrintNum());
        executor.shutdown(); //等待全部执行完毕后关闭线程池

    }




}