package com.usecase.util.map;

import com.usecase.hr.model.Employee;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class BinaryTreeMapTest {

    private TreeMap<String, String> buildMap() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("1001", "Java");
        map.put("1002", "Python");
        map.put("1003", "C");
        return map;
    }

    @Test
    public void put() {
        Map<String, String> map = buildMap();
        String r = map.put("1004", "C++");

        assertEquals(null, r);
        assertEquals(4, map.size());

        assertEquals("Java", map.values().toArray()[0]);
        assertEquals("Python", map.values().toArray()[1]);
        assertEquals("C", map.values().toArray()[2]);
        assertEquals("C++", map.values().toArray()[3]);

        System.out.println(map);
    }

    @Test
    public void putDuplicatedKey() {
        Map<String, String> map = buildMap();
        String r = map.put("1003", "C");

        assertEquals("C", r);
        assertEquals(3, map.size());
    }

    @Test
    public void putDuplicatedEmployeeKey() {
        Map<Employee, String> map = new LinkedHashMap<>();
        map.put(new Employee(100), "Java");
        map.put(new Employee(101), "Python");
        map.put(new Employee(102), "C");
        String r = map.put(new Employee(102), "C");

        assertEquals("C", r);
        assertEquals(3, map.size());
    }

    @Test
    public void containsValue() {
        Map<String, String> map = buildMap();

        //只要两个对象通过 equals 比较返回 true
        assertEquals(true, map.containsValue("Java"));
        assertEquals(true, map.containsValue("Python"));
        assertEquals(true, map.containsValue("C"));
    }

    @Test
    public void containsKey() {
        Map<String, String> map = buildMap();

        //只要两个对象通过 equals 比较返回 true
        assertEquals(true, map.containsKey("1001"));
        assertEquals(true, map.containsKey("1002"));
        assertEquals(true, map.containsKey("1003"));
    }

    @Test
    public void remove() {
        Map<String, String> map = buildMap();

        String r = map.remove("1003");
        assertEquals("C", r);
        assertEquals(2, map.size());
    }

    @Test
    public void replace() {
        Map<String, String> map = buildMap();

        String r = map.replace("1003", "C++");
        assertEquals("C", r);
        assertEquals("C++", map.get("1003"));

        assertEquals(3, map.size());
    }

    @Test
    public void replaceAll() {
        Map<String, String> map = buildMap();

        map.replaceAll((key, value) -> value + "-new");

        assertEquals("Java-new", map.get("1001"));
        assertEquals("Python-new", map.get("1002"));
        assertEquals("C-new", map.get("1003"));
    }

    @Test
    public void forEach() {
        Map<String, String> map = buildMap();

        map.forEach((key, value) -> System.out.println(key + "->" + value));
    }

    @Test
    public void forIterate() {
        Map<String, String> map = buildMap();

        for (String key : map.keySet()) {
            System.out.print(key + "->");
            System.out.print(map.get(key) + "\n");
        }

    }

    @Test
    public void firstEntry() {
        TreeMap<String, String> map = buildMap();

        assertEquals("1001", map.firstEntry().getKey());
        assertEquals("Java", map.firstEntry().getValue());
    }

    @Test
    public void lastEntry() {
        TreeMap<String, String> map = buildMap();

        assertEquals("1003", map.lastEntry().getKey());
        assertEquals("C", map.lastEntry().getValue());
    }

    @Test
    public void higherKey() {
        TreeMap<String, String> map = buildMap();

        assertEquals("1002", map.higherKey("1001"));
    }

    @Test
    public void higherEntry() {
        TreeMap<String, String> map = buildMap();

        assertEquals("Python", map.higherEntry("1001").getValue());
    }

    @Test
    public void lowerKey() {
        TreeMap<String, String> map = buildMap();

        assertEquals("1001", map.lowerKey("1002"));
    }

    @Test
    public void lowerEntry() {
        TreeMap<String, String> map = buildMap();

        assertEquals("Java", map.lowerEntry("1002").getValue());
    }

    @Test
    public void subMap() {
        TreeMap<String, String> map = buildMap();
        SortedMap<String, String> submap = map.subMap("1001", "1003");

        assertEquals(2, submap.size());
        assertEquals("1001", submap.firstKey());
        assertEquals("1002", submap.lastKey());
    }

    @Test
    public void headMap() {
        TreeMap<String, String> map = buildMap();
        SortedMap<String, String> submap = map.headMap("1003");

        assertEquals(2, submap.size());
        assertEquals("1001", submap.firstKey());
        assertEquals("1002", submap.lastKey());
    }

    @Test
    public void tailMap() {
        TreeMap<String, String> map = buildMap();
        SortedMap<String, String> submap = map.tailMap("1002");

        assertEquals(2, submap.size());
        assertEquals("1002", submap.firstKey());
        assertEquals("1003", submap.lastKey());
    }
}
