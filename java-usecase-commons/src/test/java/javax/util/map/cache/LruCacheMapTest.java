package javax.util.map.cache;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LruCacheMapTest {

    @Test
    public void put() {
        Map<Integer, Integer> map = new LruCacheMap<>(3);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        System.out.println(map);

        map.get(1);
        System.out.println(map);

        map.put(4, 4);
        System.out.println(map);
        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(2));

        map.put(5, 5);
        System.out.println(map);
        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(3));

        map.put(6, 6);
        System.out.println(map);
        assertFalse(map.containsKey(1));

        assertTrue(map.size() == 3);
    }
}