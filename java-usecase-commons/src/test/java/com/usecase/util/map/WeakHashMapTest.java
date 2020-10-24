package com.usecase.util.map;

import org.junit.Test;

import java.util.Map;
import java.util.WeakHashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeakHashMapTest {

    @Test
    public void weakHashMap() throws InterruptedException {
        Map weakHashMap = new WeakHashMap<>();
        Object key = new Object();
        Object value = new Object();
        weakHashMap.put(key, value);

        assertTrue(weakHashMap.containsValue(value));

        key = null;
        System.gc();
        Thread.sleep(1000);

        assertFalse(weakHashMap.containsValue(value));
    }
}
