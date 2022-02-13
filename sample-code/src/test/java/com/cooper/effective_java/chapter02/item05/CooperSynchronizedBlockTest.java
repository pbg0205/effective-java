package com.cooper.effective_java.chapter02.item05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CooperSynchronizedBlockTest {

    @Test
    @DisplayName("1000 micro second synchronized block method 테스트는 동시성을 보장한다.")
    public void should_equals_when_setter_is_synchronized_block() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CooperSynchronizedBlock summation = new CooperSynchronizedBlock();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));

        service.awaitTermination(1000, TimeUnit.MICROSECONDS);

        assertEquals(1000, summation.getSum());
    }

    @Test
    @DisplayName("100 micro second synchronized block method 테스트는 동시성을 보장하지 않는다.")
    public void should_not_equals_when_setter_is_synchronized_block() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CooperSynchronizedBlock summation = new CooperSynchronizedBlock();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));

        service.awaitTermination(100, TimeUnit.MICROSECONDS);

        assertNotEquals(1000, summation.getSum());
    }
}
