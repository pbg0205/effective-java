package com.cooper.effective_java.chapter02.item05;

public class CooperSynchronizedBlock {

    private int sum = 0;

    public void calculate() {
        synchronized (this) {
            sum += 1;
        }
    }

    public int getSum() {
        return sum;
    }

}
