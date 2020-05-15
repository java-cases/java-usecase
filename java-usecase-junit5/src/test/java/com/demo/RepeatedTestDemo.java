package com.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTestDemo {

    @RepeatedTest(value = 3)
    @DisplayName("execute repeated test")
    public void executeRepeatedTest() {
        System.out.println("executeRepeatedTest");
    }

    @RepeatedTest(value = 3, name = "{displayName} 第 {currentRepetition} 次")
    @DisplayName("execute repeated test with formated name")
    public void executeRepeatedTestFormatName() {
        System.out.println("executeRepeatedTest");
    }
}
