package com.cooper.effective_java.chapter02.item05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CooperSynchronizeMethodsTest {

    @Test
    @DisplayName("1000 micro second synchronized setter method는 동시성을 보장한다.")
    public void should_equals_when_setter_is_synchronized() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CooperSynchronizeMethods summation = new CooperSynchronizeMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));

        service.awaitTermination(1000, TimeUnit.MICROSECONDS);

        assertEquals(1000, summation.getSum());
    }

    @Test
    @DisplayName("100 micro second synchronized setter method는 동시성을 보장하지 못한다.")
    public void should_not_equals_when_setter_is_synchronized() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CooperSynchronizeMethods summation = new CooperSynchronizeMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));

        service.awaitTermination(100, TimeUnit.MICROSECONDS);

        assertNotEquals(1000, summation.getSum());
    }
}