package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class SumTest {
    private static Sum sum = new Sum();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(100);

        for(int k = 0; k <10000; k++) {
            Runnable r = () -> {
                sum.inc();
            };
            executor.execute(r);
        }

        executor.shutdown();
        Thread.sleep(3);
        System.out.println(sum.get());
    }


}
