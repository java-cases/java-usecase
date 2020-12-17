package com.usecase.guava.retrying;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RetryerCallable {

    private static final Logger log = LoggerFactory.getLogger(RetryerCallable.class);

    public static <T> void retryWithStopAfterAttempt(Callable<T> callable) {

        Retryer<T> retryer = RetryerBuilder.<T>newBuilder()
                .retryIfResult(Objects::isNull)
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();

        try {
            retryer.call(callable);
        } catch (RetryException e) {
            log.error(e.getMessage());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static <T> void retryWithExponentialBackoff(Callable<T> callable) {

        Retryer<T> retryer = RetryerBuilder.<T>newBuilder()
                .retryIfResult(t -> false)
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withWaitStrategy(WaitStrategies.exponentialWait(100, 5, TimeUnit.SECONDS))
                //.withStopStrategy(StopStrategies.neverStop())
                .withStopStrategy(StopStrategies.stopAfterAttempt(4))
                .build();

        try {
            retryer.call(callable);
        } catch (RetryException e) {
            log.error(e.getMessage());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static <T> void retryWithFibonacciBackoff(Callable<T> callable) {

        Retryer<T> retryer = RetryerBuilder.<T>newBuilder()
                .retryIfResult(Predicates.alwaysFalse())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withWaitStrategy(WaitStrategies.fibonacciWait(100, 2, TimeUnit.SECONDS))
                //.withStopStrategy(StopStrategies.neverStop())
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))
                .build();

        try {
            retryer.call(callable);
        } catch (RetryException e) {
            log.error(e.getMessage());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
