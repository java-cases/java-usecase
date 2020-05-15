package com.usecase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("NestedUnitTest")
public class NestedTestDemo {

    @Nested
    @DisplayName("First Nested Test")
    class FirstNestedTest {

        @Test
        void testCase() {
            System.out.println("FirstNestedTest.testCase()");
        }
    }

    @Nested
    @DisplayName("Second Nested Test")
    class SecondNestedTest {

        @Test
        void testCase() {
            System.out.println("SecondNestedTest.testCase()");
        }
    }
}
