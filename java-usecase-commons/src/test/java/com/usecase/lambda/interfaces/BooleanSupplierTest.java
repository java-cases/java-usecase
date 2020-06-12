package com.usecase.lambda.interfaces;

import org.junit.Test;

import java.util.function.BooleanSupplier;

import static org.junit.Assert.assertTrue;

public class BooleanSupplierTest {

    @Test
    public void getAsBoolean() {
        //代表了boolean值结果的提供方
        BooleanSupplier func=()-> true;
        Boolean r=func.getAsBoolean();

        assertTrue(r);
    }
}
