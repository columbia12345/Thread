package com.thread;

public class TestTread {
    public static void main(String[] args) {

        new Thread(new PrintA()).start();
        new Thread(new PrintB()).start();
        new Thread(new PrintNum()).start();
    }
}
