package com.usecase.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("NestedUnitTest")
public class NestedTestDemo {

    @Nested
    @DisplayName("First Nested Test")
    public class FirstNestedTest {

        @Test
        void testCase() {
            System.out.println("FirstNestedTest.testCase()");
        }
    }

    @Nested
    @DisplayName("Second Nested Test")
    public class SecondNestedTest {

        @Test
        void testCase() {
            System.out.println("SecondNestedTest.testCase()");
        }
    }
}
