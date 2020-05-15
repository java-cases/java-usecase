package com.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    void intValueSource(int item) {
        System.out.println(item);

        Assertions.assertEquals(0, item % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Effective Java", "Clean Code"})
    void stringValueSource(String item) {
        System.out.println(item);

        Assertions.assertTrue(item.length() > 1);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '-', value = {"1-One", "2-Two", "3-Three"})
    void csvSource(long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/testdata.csv"})
    void csvFileSource(long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }

    @ParameterizedTest(name = "[{index}] TimeUnit: {arguments}")
    @EnumSource(TimeUnit.class)
    void enumSource(TimeUnit unit) {
        Assertions.assertTrue(unit.toMillis(2000000L) > 1);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"SECONDS", "MINUTES"})
    void enumSourceJustSecondsAndMinutes(TimeUnit unit) {
        Assertions.assertTrue(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));

        Assertions.assertFalse(EnumSet.of(TimeUnit.DAYS,
                TimeUnit.HOURS,
                TimeUnit.MILLISECONDS,
                TimeUnit.NANOSECONDS,
                TimeUnit.MICROSECONDS)
                .contains(unit));
    }

    @ParameterizedTest
    @MethodSource("stringGenerator")
    void methodSource(String arg) {
        Assertions.assertNotNull(arg);
    }

    static Stream<String> stringGenerator() {
        return Stream.of("hello", "world");
    }


    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsGenerator.class)
    void testGeneratedArguments(double number) {
        Assertions.assertFalse(number == 0.D);
        Assertions.assertTrue(number > 0);
        Assertions.assertTrue(number < 1);
    }

    static class CustomArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
                    .map(Arguments::of);
        }
    }
}
