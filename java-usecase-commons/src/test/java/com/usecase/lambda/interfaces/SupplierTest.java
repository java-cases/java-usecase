package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class SupplierTest {

    @Test
    public void name() {
        //Supplier<T> 无参数，返回一个结果。
        Supplier<Integer> func = () -> 1;

        Integer r = func.get();
        assertEquals(Integer.valueOf(1), r);
    }
}
