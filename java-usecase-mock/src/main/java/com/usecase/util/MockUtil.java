package com.usecase.util;

import java.util.Random;

public class MockUtil {
    private static final Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
