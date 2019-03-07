package com.thread;

public class PrintA implements Runnable {
    @Override
    public void run() {
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%-3s", "Z");
            }
        });
        thread4.start();
        for (int i = 0; i < 5; i++) {

            if (i == 3) {
                try {
                    thread4.join(); //加塞儿
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("%-3s", "A");
        }
    }
}
