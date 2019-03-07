package com.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class Sum {

    private LongAdder  i = new LongAdder();
    public void inc(){
        i.add(3);
    }

    public int get() {
        return i.intValue();

    }
}
