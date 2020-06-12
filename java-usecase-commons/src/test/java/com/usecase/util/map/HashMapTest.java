package com.usecase.util.map;

import com.usecase.model.Employee;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HashMapTest {

    private Map<String, String> buildHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1001", "Java");
        map.put("1002", "Python");
        map.put("1003", "C");
        return map;
    }

    @Test
    public void put() {
        Map<String, String> map = new HashMap<>();
        map.put("1001", "Java");
        map.put("1002", "Python");
        String r = map.put("1003", "C");

        assertEquals(null, r);
        assertEquals(3, map.size());

        System.out.println(map);
    }


    @Test
    public void putDuplicatedKey() {
        Map<String, String> map = buildHashMap();
        String r = map.put("1003", "C");

        assertEquals("C", r);
        assertEquals(3, map.size());
    }

    @Test
    public void putDuplicatedEmployeeKey() {
        Map<Employee, String> map = new HashMap<>();
        map.put(new Employee(100), "Java");
        map.put(new Employee(101), "Python");
        map.put(new Employee(102), "C");
        String r = map.put(new Employee(102), "C");

        assertEquals("C", r);
        assertEquals(3, map.size());
    }

    @Test
    public void containsValue() {
        Map<String, String> map = buildHashMap();

        //只要两个对象通过 equals 比较返回 true
        assertEquals(true, map.containsValue("Java"));
        assertEquals(true, map.containsValue("Python"));
        assertEquals(true, map.containsValue("C"));
    }

    @Test
    public void containsKey() {
        Map<String, String> map = buildHashMap();

        //只要两个对象通过 equals 比较返回 true
        assertEquals(true, map.containsKey("1001"));
        assertEquals(true, map.containsKey("1002"));
        assertEquals(true, map.containsKey("1003"));
    }

    @Test
    public void remove() {
        Map<String, String> map = buildHashMap();

        String r = map.remove("1003");
        assertEquals("C", r);
        assertEquals(2, map.size());
    }

    @Test
    public void replace() {
        Map<String, String> map = buildHashMap();

        String r = map.replace("1003", "C++");
        assertEquals("C", r);
        assertEquals("C++", map.get("1003"));

        assertEquals(3, map.size());
    }

    @Test
    public void replaceAll() {
        Map<String, String> map = buildHashMap();

        map.replaceAll((key, value) -> value + "-new");

        assertEquals("Java-new", map.get("1001"));
        assertEquals("Python-new", map.get("1002"));
        assertEquals("C-new", map.get("1003"));
    }

    @Test
    public void forEach() {
        Map<String, String> map = buildHashMap();

        map.forEach((key, value) -> System.out.println(key + "->" + value));
    }

    @Test
    public void forIterate() {
        Map<String, String> map = buildHashMap();

        for (String key : map.keySet()) {
            System.out.print(key + "->");
            System.out.print(map.get(key) + "\n");
        }

    }


}
