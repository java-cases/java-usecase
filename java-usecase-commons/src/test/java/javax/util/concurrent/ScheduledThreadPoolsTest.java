package javax.util.concurrent;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScheduledThreadPoolsTest {

    private static final int LOOP_TIMES = 3;
    private static final int CORE_POOL_SIZE = 8;

    @Test
    public void getExecutor() {
        ExecutorService executor1 = ScheduledThreadPools.getExecutor(CORE_POOL_SIZE);
        ExecutorService executor2 = ScheduledThreadPools.getExecutor(CORE_POOL_SIZE);

        assertEquals(executor1, executor2);
    }

    @Test
    public void getScheduledExecutor() {
        ScheduledThreadPoolExecutor executor1 = ScheduledThreadPools.getScheduledExecutor(CORE_POOL_SIZE);
        ScheduledThreadPoolExecutor executor2 = ScheduledThreadPools.getScheduledExecutor(CORE_POOL_SIZE);

        assertEquals(executor1, executor2);
    }

    @Test
    public void execute() {

        Runnable action = () -> System.out.println("execute(action)");
        ExecutorService executor = ScheduledThreadPools.getExecutor(CORE_POOL_SIZE);

        for (int i = 0; i < LOOP_TIMES; i++) {
            executor.execute(action);
        }
    }


    @Test
    public void submit()
            throws ExecutionException, InterruptedException {

        Callable<Integer> action = () -> new Random().nextInt(100);
        ExecutorService executor = ScheduledThreadPools.getExecutor(CORE_POOL_SIZE);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < LOOP_TIMES; i++) {
            Future<Integer> futrue = executor.submit(action);
            map.put(i, futrue.get());
        }

        System.out.println(map);

        assertEquals(3, map.size());

        assertTrue(map.values().stream().allMatch(x -> x <= 100));
    }

    @Test
    public void scheduleRunnable()
            throws InterruptedException {

        Runnable action = () -> System.out.println("schedule(action)");
        ScheduledThreadPoolExecutor executor = ScheduledThreadPools.getScheduledExecutor(CORE_POOL_SIZE);

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < LOOP_TIMES; i++) {
            ScheduledFuture<?> futrue = executor.schedule(action, 10, TimeUnit.MILLISECONDS);
            Thread.sleep(15);
            map.put(i, futrue.isDone());
        }

        System.out.println(map);
        assertEquals(3, map.size());

        assertTrue(map.values().stream().allMatch(x -> x == true));
    }

    @Test
    public void scheduleCallable()
            throws InterruptedException, ExecutionException {

        Callable<Integer> action = () -> new Random().nextInt(100);
        ScheduledThreadPoolExecutor executor = ScheduledThreadPools.getScheduledExecutor(CORE_POOL_SIZE);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < LOOP_TIMES; i++) {
            ScheduledFuture<Integer> futrue = executor.schedule(action, 10, TimeUnit.MILLISECONDS);
            Thread.sleep(15);
            map.put(i, futrue.get());
        }

        System.out.println(map);
        assertEquals(3, map.size());

        assertTrue(map.values().stream().allMatch(x -> x < 100));
    }
}