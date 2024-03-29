package com.usecase.junit5;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class Junit5Demo {

    @BeforeAll
    public static void init() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("@AfterAll - executed after all test methods.");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @Test
    @DisplayName("execute implemented case")
    public void executeImplementedCase() {
        System.out.println("execute implemented case");
    }

    @Test
    @DisplayName("disabled unimplemented case")
    @Disabled("disabled unimplemented case")
    public void disabledUnimplementedCase() {
    }

    @Test
    public void assertAllCases() {
        int[] numbers = {0, 1, 2, 3, 4};

        assertAll(() -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[4], 4)
        );
    }

    @Test
    public void assertTrueCase() {
        assertTrue(Stream.of(1, 2, 3).mapToInt(i -> i).sum() > 5);
    }

    @Test
    public void assertTrueWithLambda() {
        Supplier<String> messageSupplier = () -> "message: assertTrue";
        assertTrue(Stream.of(1, 2, 3).mapToInt(i -> i).sum() > 5, messageSupplier);
    }

    @Test
    public void assumeTrueCase() {
        assumeTrue(5 > 1);
    }

    @Test
    public void assumeFalseCase() {
        assumeFalse(5 < 1);
    }

    @Test
    public void assertEqualsCase() {
        assertEquals(5 + 2, 7);
    }

    @Test
    public void assumingThatCase() {
        String someString = "Just a string";

        assumingThat(someString.equals("Just a string"),
                () -> assertEquals(2 + 2, 4)
        );
    }

    @Test
    @DisplayName("assert throws exception")
    public void assertThrowsCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(null);
        });
    }

    @Test
    @DisplayName("assert throws exception and check message")
    public void assertThrowsCaseCheckMessage() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });

        assertEquals(exception.getMessage(), "Not supported");
    }

    @Test
    @DisplayName("assert timeout preemptively case")
    public void assertTimeoutPreemptivelyCase() {
        assertTimeoutPreemptively(Duration.of(1, ChronoUnit.SECONDS),
                () -> Thread.sleep(900));
    }
}
