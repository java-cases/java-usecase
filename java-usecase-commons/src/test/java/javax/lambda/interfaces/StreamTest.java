package javax.lambda.interfaces;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StreamTest {

    @Test
    public void filter() {
        List<Integer> numbers = Arrays.asList(4, 3, 2, 1, 2, 3, 4);

        // filter 方法用于通过设置的条件过滤出元素。
        List<Integer> list = numbers.stream()
                .filter(x -> x > 3)
                .collect(Collectors.toList());

        assertEquals(2, list.size());
        assertEquals(true, list.contains(4));
    }

    @Test
    public void map() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // map 方法用于映射每个元素到对应的结果
        List<Integer> squares = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        assertEquals(4, squares.size());
        assertEquals(true, squares.contains(1));
        assertEquals(true, squares.contains(4));
        assertEquals(true, squares.contains(9));
        assertEquals(true, squares.contains(16));

        System.out.println(squares);
    }

    @Test
    public void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // reduce实现了对List中的元素累加
        // lambada表达式的x参数是表达式的执行结果的缓存，也就是表达式这一次的执行结果会被作为下一次执行的参数，
        // 而第二个参数y则是依次为stream中每个元素。
        Integer r = numbers.stream()
                .map(x -> x * x)
                .distinct()
                .reduce((x, y) -> x + y)
                .get();

        assertEquals(Integer.valueOf(30), r);
    }

    @Test
    public void reduceWithIdentity() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // reduce实现了对List中的元素累加
        // 首次执行时表达式第一次参数并不是stream的第一个元素，而是通过签名的第一个参数identity来指定。
        int r = numbers.stream()
                .map(x -> x * x)
                .distinct()
                .reduce(10, (x, y) -> x + y)
                .intValue();

        assertEquals(40, r);
    }

    @Test
    public void reduceWithBinaryOperator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        BinaryOperator<Integer> accumulator = (x, y) -> {
            System.out.println("x=" + x + ",y=" + y);
            return x + y;
        };

        // reduce实现了对List中的元素累加
        Integer r = numbers.stream()
                .map(x -> x * x)
                .distinct()
                .reduce(accumulator)
                .get();

        assertEquals(Integer.valueOf(30), r);
    }

    @Test
    public void distinct() {
        List<Integer> numbers = Arrays.asList(4, 3, 2, 1, 2, 3, 4);

        List<Integer> squares = numbers.stream()
                .map(x -> x * x)
                .distinct()
                .collect(Collectors.toList());

        assertEquals(4, squares.size());
        assertEquals(true, squares.contains(1));
        assertEquals(true, squares.contains(4));
        assertEquals(true, squares.contains(9));
        assertEquals(true, squares.contains(16));

        System.out.println(squares);
    }

    @Test
    public void limit() {
        Random random = new Random();

        // limit 方法用于获取指定数量的流。
        long count = random.ints(20)
                .limit(10)
                .count();

        assertEquals(10, count);
    }

    @Test
    public void count() {
        Random random = new Random();

        // limit 方法用于获取指定数量的流。
        long count = random.ints(20).count();

        assertEquals(20, count);
    }


    @Test
    public void sorted() {
        List<Integer> numbers = Arrays.asList(4, 1, 2, 3);

        // filter 方法用于通过设置的条件过滤出元素。
        List<Integer> list = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));
    }

    @Test
    public void sortedWithNaturalOrderComparator() {
        List<Integer> numbers = Arrays.asList(4, 1, 2, 3);

        // filter 方法用于通过设置的条件过滤出元素。
        List<Integer> list = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));
    }

    @Test
    public void sortedWithComparator() {
        List<Integer> numbers = Arrays.asList(4, 1, 2, 3);

        // filter 方法用于通过设置的条件过滤出元素。
        List<Integer> list = numbers.stream()
                .sorted((x, y) -> y.compareTo(x))
                .collect(Collectors.toList());

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(4), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(1), list.get(3));
    }

    @Test
    public void sortedWithReverseOrderComparator() {
        List<Integer> numbers = Arrays.asList(4, 1, 2, 3);

        // filter 方法用于通过设置的条件过滤出元素。
        List<Integer> list = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(4), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
        assertEquals(Integer.valueOf(1), list.get(3));
    }

    @Test
    public void forEach() {
        Random random = new Random();

        // forEach 迭代流中的每个数据。
        random.ints(3).forEach(System.out::println);
    }

    @Test
    public void summaryStatistics() {
        List<Integer> numbers = Arrays.asList(4, 3, 2, 1, 2, 3, 4);

        // 产生统计结果的收集器
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("列表中元素数量 : " + stats.getCount());
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
