package com.usecase.guava.retrying;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class RetryerCallableTest {

    @Test
    void retryWithStopAfterAttempt() {
        Callable<Object> callable = new Callable<Object>() {
            public Object call() throws Exception {
                return null; // do something useful here
            }
        };

        RetryerCallable.retryWithStopAfterAttempt(callable);
    }

    @Test
    void retryWithExponentialBackoff() {
        RetryerCallable.retryWithExponentialBackoff(() -> {
            throw new InvalidParameterException();
        });
    }

    @Test
    void retryWithFibonacciBackoff() {
        RetryerCallable.retryWithFibonacciBackoff(() -> {
            throw new IllegalStateException();
        });
    }
}