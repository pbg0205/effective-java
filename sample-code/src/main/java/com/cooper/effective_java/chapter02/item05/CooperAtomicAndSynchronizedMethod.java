package com.cooper.effective_java.chapter02.item05;

import java.util.concurrent.atomic.AtomicInteger;

public class CooperAtomicAndSynchronizedMethod {

    private final AtomicInteger sum = new AtomicInteger(0);

    public synchronized void calculate() {
        sum.getAndIncrement();
    }

    public int getSum() {
        return sum.get();
    }
}
