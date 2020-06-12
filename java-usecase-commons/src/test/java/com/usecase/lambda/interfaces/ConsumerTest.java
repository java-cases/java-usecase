package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.Consumer;

public class ConsumerTest {

    @Test
    public void accept() {
        //Consumer<T> 代表了接受一个输入参数并且无返回的操作
        Consumer<String> func= x-> System.out.println(x);
        func.accept("hello");
    }
}
