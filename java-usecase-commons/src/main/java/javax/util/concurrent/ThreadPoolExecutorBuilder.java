package javax.util.concurrent;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class ThreadPoolExecutorBuilder {

    public static final int DEFAULT_CORE_POOL_SIZE = 8;
    public static final int DEFAULT_MAXIMUM_POOL_SIZE = 8;

    private volatile int corePoolSize;
    private volatile int maximumPoolSize;
    private volatile long keepAliveTime;
    private TimeUnit unit;
    private BlockingQueue<Runnable> workQueue;
    private ThreadFactory threadFactory;
    private RejectedExecutionHandler handler;

    public ThreadPoolExecutorBuilder corePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        return this;
    }

    public ThreadPoolExecutorBuilder maximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
        return this;
    }

    public ThreadPoolExecutorBuilder keepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
        return this;
    }

    public ThreadPoolExecutorBuilder unit(TimeUnit unit) {
        this.unit = unit;
        return this;
    }

    public ThreadPoolExecutorBuilder workQueue(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        return this;
    }

    public ThreadPoolExecutorBuilder threadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        return this;
    }

    public ThreadPoolExecutorBuilder handler(RejectedExecutionHandler handler) {
        this.handler = handler;
        return this;
    }

    private ThreadPoolExecutorBuilder() {

    }

    public static ThreadPoolExecutorBuilder builder() {
        return new ThreadPoolExecutorBuilder();
    }

    public static ThreadPoolExecutorBuilder defaultBuilder() {
        return new ThreadPoolExecutorBuilder()
                .corePoolSize(DEFAULT_CORE_POOL_SIZE)
                .maximumPoolSize(DEFAULT_MAXIMUM_POOL_SIZE)
                .keepAliveTime(0)
                .unit(NANOSECONDS)
                .threadFactory(Executors.defaultThreadFactory())
                .handler(new ThreadPoolExecutor.AbortPolicy())
                .workQueue(new ArrayBlockingQueue(DEFAULT_MAXIMUM_POOL_SIZE));
    }

    public static ThreadPoolExecutor defaultInstance() {
        return defaultBuilder().build();
    }

    public ThreadPoolExecutor build() {

        if (this.corePoolSize < 0 ||
                this.maximumPoolSize <= 0 ||
                this.maximumPoolSize < this.corePoolSize ||
                this.keepAliveTime < 0) {
            throw new IllegalArgumentException();
        }

        if (this.workQueue == null || this.threadFactory == null || this.handler == null) {
            throw new NullPointerException();
        }

        return new ThreadPoolExecutor(this.corePoolSize,
                this.maximumPoolSize,
                this.keepAliveTime,
                this.unit,
                this.workQueue,
                this.threadFactory,
                this.handler);
    }
}