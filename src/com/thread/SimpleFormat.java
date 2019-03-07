package com.thread;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleFormat {
    private static  ThreadLocal<Sum> threadLocal = ThreadLocal.withInitial(() -> new Sum());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int k = 0; k < 100; k++) {
            Runnable r = ()-> threadLocal.get().inc();
            executorService.execute(r);
        }

        executorService.shutdown();
        Thread.sleep(1000);
        System.out.println(threadLocal.get().get());
    }


}
