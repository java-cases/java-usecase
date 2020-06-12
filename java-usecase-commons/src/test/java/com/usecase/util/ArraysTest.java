package com.usecase.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraysTest {

    private int[] buildNumbers() {
        return new int[]{4, 3, 2, 1, 0};
    }

    private Integer[] buildIntegers() {
        return new Integer[]{4, 3, 2, 1, 0};
    }

    private Object[] buildObjects() {
        return new Integer[]{4, 3, 2, 1, 0};
    }

    @Test
    public void asList() {
        List<Integer> numbers = Arrays.asList(buildIntegers());

        assertEquals(5, numbers.size());
        System.out.println(numbers);
    }

    @Test
    public void sort() {
        int[] numbers = buildNumbers();
        Arrays.sort(numbers);

        assertEquals(0, numbers[0]);
        assertEquals(4, numbers[4]);
    }

    @Test
    public void parallelSort() {
        int[] numbers = buildNumbers();
        Arrays.parallelSort(numbers);

        assertEquals(0, numbers[0]);
        assertEquals(4, numbers[4]);
    }


    @Test
    public void binarySearch() {
        int[] numbers = buildNumbers();
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, 2);

        assertEquals(2, index);
    }


    @Test
    public void binarySearchWithoutSorting() {
        int[] numbers = buildNumbers();
        int index = Arrays.binarySearch(numbers, 2);

        assertEquals(2, index);
    }

    @Test
    public void binarySearchWithMissingElement() {
        int[] numbers = buildNumbers();
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, -100);

        assertEquals(-1, index);
    }

    @Test
    public void copyOf() {
        int[] numbers = buildNumbers();
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length);

        assertEquals(5, newNumbers.length);
        assertEquals(4, newNumbers[0]);
        assertEquals(0, newNumbers[4]);

        assertEquals(false, numbers.equals(newNumbers));
        System.out.println(numbers);
        System.out.println(newNumbers);
    }

    @Test
    public void copyOfMoreThanSource() {
        int[] numbers = buildNumbers();
        int[] newNumbers = Arrays.copyOf(numbers, 10);

        assertEquals(10, newNumbers.length);
        assertEquals(4, newNumbers[0]);
        assertEquals(0, newNumbers[4]);

        assertEquals(0, newNumbers[5]);
        assertEquals(0, newNumbers[9]);

        System.out.println(Arrays.toString(newNumbers));
    }

    @Test
    public void copyOfLessThanSource() {
        int[] numbers = buildNumbers();
        int[] newNumbers = Arrays.copyOf(numbers, 2);

        assertEquals(2, newNumbers.length);
        assertEquals(4, newNumbers[0]);
        assertEquals(3, newNumbers[1]);

        System.out.println(Arrays.toString(newNumbers));
    }

    @Test
    public void equalsOfArrays() {
        int[] numbers = buildNumbers();
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length);

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(true, Arrays.equals(numbers, numbers));
        assertEquals(true, Arrays.equals(numbers, newNumbers));
    }

    @Test
    public void equalsOfNullArrays() {
        int[] numbers = buildNumbers();

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(false, Arrays.equals(numbers, null));
    }

    @Test
    public void equalsOfDiffLengthArrays() {
        int[] numbers = buildNumbers();
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length - 1);

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(false, Arrays.equals(numbers, newNumbers));
    }

    @Test
    public void equalsOfDiffElementsArrays() {
        int[] numbers = buildNumbers();
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length);
        newNumbers[numbers.length - 1] = 100;

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(false, Arrays.equals(numbers, newNumbers));
    }

    @Test
    public void deepEqualsOfArrays() {
        Object[] numbers = buildObjects();
        Object[] newNumbers = Arrays.copyOf(numbers, numbers.length);

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(true, Arrays.deepEquals(numbers, numbers));
        assertEquals(true, Arrays.deepEquals(numbers, newNumbers));
    }

    @Test
    public void deepEqualsOfNullArrays() {
        Object[] numbers = buildObjects();

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(false, Arrays.deepEquals(numbers, null));
    }

    @Test
    public void deepEqualsOfDiffLengthArrays() {
        Object[] numbers = buildObjects();
        Object[] newNumbers = Arrays.copyOf(numbers, numbers.length - 1);

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(false, Arrays.deepEquals(numbers, newNumbers));
    }

    @Test
    public void deepEqualsOfDiffElementsArrays() {
        Object[] numbers = buildObjects();
        Object[] newNumbers = Arrays.copyOf(numbers, numbers.length);
        newNumbers[numbers.length - 1] = 100;

        //1 对比引用是否相同; 2 对比是否存在 null; 3 对比长度是否相同; 4 挨个元素对比
        assertEquals(false, Arrays.deepEquals(numbers, newNumbers));
    }

    @Test
    public void hashCodeOfIntArray() {
        int[] numbers = buildNumbers();
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length);

        assertEquals(Arrays.hashCode(newNumbers), Arrays.hashCode(numbers));
        System.out.println(Arrays.hashCode(numbers));
    }

    @Test
    public void hashCodeOfObjectArray() {
        Object[] numbers = buildObjects();
        Object[] newNumbers = Arrays.copyOf(numbers, numbers.length);

        assertEquals(Arrays.hashCode(newNumbers), Arrays.hashCode(numbers));
        System.out.println(Arrays.hashCode(numbers));
    }

    @Test
    public void deepHashCodeOfArray() {
        Object[] numbers = buildObjects();
        Object[] newNumbers = Arrays.copyOf(numbers, numbers.length);

        assertEquals(Arrays.deepHashCode(newNumbers), Arrays.deepHashCode(numbers));
        System.out.println(Arrays.deepHashCode(numbers));
    }

    @Test
    public void printArray() {
        int[] numbers = buildNumbers();

        assertEquals(true, numbers.toString().startsWith("[I"));
        System.out.println(numbers);
    }

    @Test
    public void toStringOfArrays() {
        int[] numbers = buildNumbers();

        assertEquals(true, Arrays.toString(numbers).startsWith("["));
        assertEquals(true, Arrays.toString(numbers).endsWith("]"));
        System.out.println(Arrays.toString(numbers));
    }

    @Test
    public void deepToStringOfArrays() {
        Object[] numbers = buildObjects();

        assertEquals(true, Arrays.deepToString(numbers).startsWith("["));
        assertEquals(true, Arrays.deepToString(numbers).endsWith("]"));
        System.out.println(Arrays.deepToString(numbers));
    }

    @Test
    public void fill() {
        int[] numbers = buildNumbers();
        Arrays.fill(numbers, -1);

        assertTrue(Arrays.stream(numbers).allMatch(x -> x == -1));
    }

    @Test
    public void fillObjectArray() {
        Object[] numbers = buildObjects();
        Arrays.fill(numbers, -1);

        assertTrue(Arrays.stream(numbers).allMatch(x -> (int) x == -1));
    }

    @Test
    public void fillRange() {
        int[] numbers = buildNumbers();
        Arrays.fill(numbers, 0, numbers.length, -1);

        assertTrue(Arrays.stream(numbers).allMatch(x -> x == -1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void fillRangeOutOfBounds() {
        int[] numbers = buildNumbers();
        Arrays.fill(numbers, 0, numbers.length + 1, -1);
    }

    @Test
    public void setAll() {
        int[] numbers = buildNumbers();
        Arrays.setAll(numbers, x -> x + 1);

        System.out.println(Arrays.toString(numbers));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5}, numbers));
    }

    @Test
    public void parallelSetAll() {
        int[] numbers = buildNumbers();
        Arrays.parallelSetAll(numbers, x -> x + 1);

        System.out.println(Arrays.toString(numbers));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5}, numbers));
    }

    @Test
    public void setAllInteger() {
        Integer[] numbers = buildIntegers();
        Arrays.setAll(numbers, x -> x + 1);

        System.out.println(Arrays.toString(numbers));
        assertTrue(Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, numbers));
    }

    @Test
    public void parallelSetAllInteger() {
        Integer[] numbers = buildIntegers();
        Arrays.parallelSetAll(numbers, x -> x + 1);

        System.out.println(Arrays.toString(numbers));
        assertTrue(Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, numbers));
    }

    @Test
    public void parallelPrefix() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};

        //reduceByKey
        Arrays.parallelPrefix(numbers, (x, y) -> x + y);

        System.out.println(Arrays.toString(numbers));
        assertTrue(Arrays.equals(new int[]{1, 3, 6, 10, 15}, numbers));
    }

    @Test
    public void parallelPrefixOfRange() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};

        //reduceByKey
        Arrays.parallelPrefix(numbers, 0, 2, (x, y) -> x + y);

        System.out.println(Arrays.toString(numbers));
        assertTrue(Arrays.equals(new int[]{1, 3, 3, 4, 5}, numbers));
    }

    @Test
    public void stream() {
        int[] numbers = buildNumbers();
        Arrays.stream(numbers).forEach(System.out::println);
    }
}
