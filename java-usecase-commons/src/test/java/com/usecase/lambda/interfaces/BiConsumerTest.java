package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.BiConsumer;

public class BiConsumerTest {

    @Test
    public void accept() {
        //BiConsumer<T,U> 代表了一个接受两个输入参数的操作，并且不返回任何结果
        BiConsumer<Integer, Long> func = (x, y) -> System.out.println(x + y);

        func.accept(1, 2L);
    }
}
