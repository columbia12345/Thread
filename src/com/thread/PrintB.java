package com.thread;

public class PrintB implements Runnable {
    @Override
    public void run() {
            for(int i= 0; i < 5; System.out.printf("%-3s","B"),i++ );

    }

    public static class PrintNumTest {
        public static void main(String[] args) {
            //new Thread(new PrintA().start())
            //start方法自动调用run当法
        }
    }
}
