package com.usecase.lambda;

import java.util.function.*;

public class ConsumerActions {

    /**
     * Consumer<T> 代表了接受一个输入参数并且无返回的操作
     *
     * @return
     */
    public static Consumer<Integer> consumer() {
        return x -> System.out.println("Consumer<T>:" + x);
    }

    /**
     * BiConsumer<T,U> 代表了一个接受两个输入参数的操作，并且不返回任何结果
     *
     * @return
     */
    public static BiConsumer<Integer, Long> biConsumer() {
        return (x, y) -> System.out.println(x + y);
    }

    /**
     * 代表一个接受double值参数的操作，并且不返回结果。
     *
     * @return
     */
    public static DoubleConsumer doubleConsumer() {
        return x -> System.out.println("DoubleConsumer:" + x);
    }

    /**
     * 接受一个int类型的输入参数，无返回值 。
     *
     * @return
     */
    public static IntConsumer intConsumer() {
        return x -> System.out.println("IntConsumer:" + x);
    }

    /**
     * 接受一个long类型的输入参数，无返回值。
     *
     * @return
     */
    public static LongConsumer longConsumer() {
        return x -> System.out.println("LongConsumer:" + x);
    }

    /**
     * objDoubleConsumer<T> 接受一个object类型和一个double类型的输入参数，无返回值。
     *
     * @return
     */
    public static ObjDoubleConsumer<String> objDoubleConsumer() {
        return (s, d) -> {
            System.out.println("ObjDoubleConsumer:" + s + "," + d);
        };
    }

    /**
     * objIntConsumer<T> 接受一个object类型和一个int类型的输入参数，无返回值。
     *
     * @return
     */
    public static ObjIntConsumer<String> objIntConsumer() {
        return (s, d) -> {
            System.out.println("ObjIntConsumer:" + s + "," + d);
        };
    }

    /**
     * objLongConsumer<T> 接受一个object类型和一个long类型的输入参数，无返回值。
     *
     * @return
     */
    public static ObjLongConsumer<String> objLongConsumer() {
        return (s, d) -> {
            System.out.println("ObjLongConsumer:" + s + "," + d);
        };
    }
}
