package com.usecase.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ParameterizedTestDemo {

    static Stream<String> stringGenerator() {
        return Stream.of("hello", "world");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    public void intValueSource(int item) {
        System.out.println(item);

        Assertions.assertEquals(0, item % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Effective Java", "Clean Code"})
    public void stringValueSource(String item) {
        System.out.println(item);

        Assertions.assertTrue(item.length() > 1);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '-', value = {"1-One", "2-Two", "3-Three"})
    public void csvSource(long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/testdata.csv"})
    public void csvFileSource(long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }

    @ParameterizedTest(name = "[{index}] TimeUnit: {arguments}")
    @EnumSource(TimeUnit.class)
    public void enumSource(TimeUnit unit) {
        Assertions.assertTrue(unit.toMillis(2000000L) > 1);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"SECONDS", "MINUTES"})
    public void enumSourceJustSecondsAndMinutes(TimeUnit unit) {
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
    public void methodSource(String arg) {
        Assertions.assertNotNull(arg);
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsGenerator.class)
    public void testGeneratedArguments(double number) {
        Assertions.assertFalse(number == 0.D);
        Assertions.assertTrue(number > 0);
        Assertions.assertTrue(number < 1);
    }

    public static class CustomArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
                    .map(Arguments::of);
        }
    }
}
