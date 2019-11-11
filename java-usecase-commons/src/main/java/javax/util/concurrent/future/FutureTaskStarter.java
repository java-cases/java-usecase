package javax.util.concurrent.future;

import java.util.Objects;
import java.util.concurrent.*;

public class FutureTaskStarter<V> {

    public static <V> Future<V> submit(Callable<V> callable) {
        Objects.requireNonNull(callable);

        FutureTask<V> task = new FutureTask<V>(callable);
        new Thread(task).start();

        return task;
    }

    public Future<V> submit(Runnable runnable, V result) {
        Objects.requireNonNull(runnable);

        FutureTask<V> task = new FutureTask<V>(runnable, result);
        new Thread(task).start();

        return task;
    }

    public V start(Callable<V> callable, int timeoutMilliseconds)
            throws ExecutionException, InterruptedException, TimeoutException {
        Objects.requireNonNull(callable);

        FutureTask<V> task = new FutureTask<V>(callable);
        new Thread(task).start();

        return task.isDone() ? task.get() : task.get(timeoutMilliseconds, TimeUnit.MILLISECONDS);
    }

    public V start(Runnable runnable, V result)
            throws ExecutionException, InterruptedException {
        Objects.requireNonNull(runnable);

        FutureTask<V> task = new FutureTask<V>(runnable, result);
        new Thread(task).start();

        return task.get();
    }


}
