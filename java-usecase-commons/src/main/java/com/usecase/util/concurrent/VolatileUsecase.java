package com.usecase.util.concurrent;

public class VolatileUsecase {

    private static volatile boolean isStop = false;

    public static void run() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!isStop) ;
        });

        thread.start();
        Thread.sleep(1000);

        isStop = true;
    }
}
