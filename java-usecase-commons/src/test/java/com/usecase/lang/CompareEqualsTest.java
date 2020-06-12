package com.usecase.lang;

import org.junit.Test;

public class CompareEqualsTest {

    @Test
    public void equalsPrimitiveType() {
        CompareEquals.equalsPrimitiveType();
    }

    @Test
    public void equalsStringInPool() {
        CompareEquals.equalsStringInPool();
    }

    @Test
    public void equalsString() {
        CompareEquals.equalsString();
    }

    @Test
    public void equalsInteger() {
        CompareEquals.equalsInteger();
    }

    @Test
    public void equalsIntegerInstance() {
        CompareEquals.equalsIntegerInstance();
    }
}