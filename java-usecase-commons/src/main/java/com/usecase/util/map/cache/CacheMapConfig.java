package com.usecase.util.map.cache;

public class CacheMapConfig {

    public static final int MAX_CACHE_SIZE = 10000000;
    public static final float DEFAULT_LOAD_FACTORY = 0.75f;
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    public static int calculateCapacity() {
        return calculateCapacity(0);
    }

    public static int calculateCapacity(int cacheSize) {
        if (cacheSize < 0) {
            throw new IllegalArgumentException("Illegal cacheSize: " +
                    cacheSize);
        }

        if (cacheSize == 0) {
            cacheSize = DEFAULT_INITIAL_CAPACITY;
        }

        if (cacheSize > MAX_CACHE_SIZE) {
            cacheSize = MAX_CACHE_SIZE;
        }

        return (int) Math.ceil(cacheSize / DEFAULT_LOAD_FACTORY) + 1;
    }

}
