package com.usecase.util.concurrent.future;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;

public class FutureTaskxTest {

    @Test
    public void submit()
            throws ExecutionException, InterruptedException {

        FutureTaskStarter<String> starter = new FutureTaskStarter<>();
        Future<String> future = starter.submit(() -> "ok");

        assertEquals("ok", future.get());
    }

    @Test
    public void submitRunnable() throws ExecutionException, InterruptedException {
        Integer arg = 1;
        FutureTaskStarter<Integer> starter = new FutureTaskStarter<>();
        Future<Integer> future = starter.submit(() -> System.out.println("submitRunnable ok"), arg);

        assertEquals(arg, future.get());
    }

    @Test
    public void start()
            throws InterruptedException, ExecutionException, TimeoutException {

        FutureTaskStarter<String> starter = new FutureTaskStarter<>();
        String r = starter.start(() -> "ok", 1000);

        assertEquals("ok", r);
    }

    @Test
    public void startRunnable() throws ExecutionException, InterruptedException {

        Integer arg = 1;
        FutureTaskStarter<Integer> starter = new FutureTaskStarter<>();
        Integer r = starter.start(() -> System.out.println("startRunnable ok"), arg);

        assertEquals(arg, r);
    }
}