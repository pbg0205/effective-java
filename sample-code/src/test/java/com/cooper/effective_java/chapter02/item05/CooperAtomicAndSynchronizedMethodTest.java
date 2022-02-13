package com.cooper.effective_java.chapter02.item05;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CooperAtomicAndSynchronizedMethodTest {

    @Test
    void should_equals_when_atomic_field() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CooperAtomicAndSynchronizedMethod summation = new CooperAtomicAndSynchronizedMethod();

        IntStream.range(0, 1000)
                        .forEach(count -> summation.calculate());

        service.awaitTermination(10, TimeUnit.MICROSECONDS);

        assertEquals(1000, summation.getSum());
    }
}