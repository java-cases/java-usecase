package com.usecase.util.concurrent;

import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ThreadPoolExecutorBuilderTest {

    @Test
    public void defaultBuilder() {
        ThreadPoolExecutor executor = ThreadPoolExecutorBuilder.defaultBuilder()
                .build();

        assertNotNull(executor);
        assertNotNull(executor.getQueue());
        assertNotNull(executor.getRejectedExecutionHandler());
        assertNotNull(executor.getThreadFactory());

        assertEquals(ThreadPoolExecutorBuilder.DEFAULT_MAXIMUM_POOL_SIZE, executor.getMaximumPoolSize());
        assertEquals(ThreadPoolExecutorBuilder.DEFAULT_CORE_POOL_SIZE, executor.getCorePoolSize());

        assertEquals(0, executor.getKeepAliveTime(TimeUnit.NANOSECONDS));
    }

    @Test
    public void defaultInstance() {
        ThreadPoolExecutor executor = ThreadPoolExecutorBuilder.defaultInstance();

        assertNotNull(executor);
        assertNotNull(executor.getQueue());
        assertNotNull(executor.getRejectedExecutionHandler());
        assertNotNull(executor.getThreadFactory());

        assertEquals(ThreadPoolExecutorBuilder.DEFAULT_MAXIMUM_POOL_SIZE, executor.getMaximumPoolSize());
        assertEquals(ThreadPoolExecutorBuilder.DEFAULT_CORE_POOL_SIZE, executor.getCorePoolSize());

        assertEquals(0, executor.getKeepAliveTime(TimeUnit.NANOSECONDS));
    }


    @Test
    public void build() {

        ThreadPoolExecutor executor = ThreadPoolExecutorBuilder.defaultBuilder()
                .maximumPoolSize(100)
                .corePoolSize(50)
                .keepAliveTime(10)
                .unit(TimeUnit.SECONDS)
                .build();

        assertNotNull(executor);
        assertNotNull(executor.getQueue());
        assertNotNull(executor.getRejectedExecutionHandler());
        assertNotNull(executor.getThreadFactory());

        assertEquals(100, executor.getMaximumPoolSize());
        assertEquals(50, executor.getCorePoolSize());

        assertEquals(10, executor.getKeepAliveTime(TimeUnit.SECONDS));
    }
}