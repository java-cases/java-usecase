package com.usecase.lang.numbers;

public class Integerx {

    /**
     * 每次都会新建一个对象。
     *
     * @param i
     * @return
     */
    public static Integer newInteger(int i) {
        return new Integer(i);
    }

    public static Integer newInteger(String s) {
        return new Integer(s);
    }

    public static int parseInt(String s, int radix) {
        return Integer.parseInt(s, radix);
    }

    public static int parseInt(String s) throws NumberFormatException {
        return parseInt(s, 10);
    }

    public static int parseUnsignedInt(String s, int radix) {
        return Integer.parseUnsignedInt(s, radix);
    }

    public static int parseUnsignedInt(String s) throws NumberFormatException {
        return parseUnsignedInt(s, 10);
    }

    /**
     * 会使用缓存池中的对象，多次调用会取得同一个对象的引用。先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
     * 在 Java 8 中，Integer缓存池的大小默认为 -128\~127。
     *
     * @param i
     * @return
     */
    public static Integer valueOf(int i) {
        return Integer.valueOf(i);
    }

    public static Integer valueOf(String s, int radix) {
        return Integer.valueOf(parseInt(s, radix));
    }

    public static Integer valueOf(String s) throws NumberFormatException {
        return Integer.valueOf(parseInt(s, 10));
    }

    /**
     * 自动装箱 （基本类型转化为包装类型）,实际上就是 Integer x=Integer.valueOf(i);
     *
     * @param i
     * @return
     */
    public static Integer boxing(int i) {
        return i;
    }

    public static Integer boxingByValueOf(int i) {
        return Integer.valueOf(i);
    }

    /**
     * 自动拆箱,
     *
     * @param x
     * @return
     */
    public static Integer unboxing(Integer x) {
        x = x + 5;
        return x;
    }

    /**
     * x.intValue()就是拆箱-->先拆箱，再装箱。
     *
     * @param x
     * @return
     */
    public static Integer unboxingByIntValue(Integer x) {
        return Integer.valueOf(x.intValue() + 5);
    }
}
