package com.thread;

public class PrintNum implements Runnable {
    @Override
    public void run() {
            for(int i= 0; i < 5; System.out.printf("%-3d",i),i++ );

    }
}
