package javax.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ScheduledThreadPools {

    private static volatile ExecutorService runnableExecutor;
    private static volatile ScheduledThreadPoolExecutor scheduledExecutor;

    public static ExecutorService getExecutor(int corePoolSize) {
        if (runnableExecutor != null) {
            return runnableExecutor;
        }

        synchronized (ScheduledThreadPools.class) {
            if (runnableExecutor == null) {
                runnableExecutor = new ScheduledThreadPoolExecutor(corePoolSize);
            }
        }

        return runnableExecutor;
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor(int corePoolSize) {
        if (scheduledExecutor != null) {
            return scheduledExecutor;
        }

        synchronized (ScheduledThreadPools.class) {
            if (scheduledExecutor == null) {
                scheduledExecutor = new ScheduledThreadPoolExecutor(corePoolSize);
            }
        }

        return scheduledExecutor;
    }

}
