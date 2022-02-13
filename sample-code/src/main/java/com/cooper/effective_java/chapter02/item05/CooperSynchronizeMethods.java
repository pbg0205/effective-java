package com.cooper.effective_java.chapter02.item05;

public class CooperSynchronizeMethods {

    private int sum = 0;

    public synchronized void calculate() {
        sum += 1;
    }

    public int getSum() {
        return sum;
    }

    public synchronized void setSum(int sum) {
        this.sum = sum;
    }
}
