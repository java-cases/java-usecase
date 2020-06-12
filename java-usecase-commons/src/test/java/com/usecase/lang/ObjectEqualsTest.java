package com.usecase.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ObjectEqualsTest {

    @Test
    public void equalsOfCustomObject() {
        ObjectEquals obj1 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj2 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj3 = new ObjectEquals(1, 2, 4);

        Assert.assertTrue(obj1.equals(obj2));

        Assert.assertFalse(obj1.equals(obj3));
    }

    @Test
    public void hashCodeOfCustomObject() {
        ObjectEquals obj1 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj2 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj3 = new ObjectEquals(1, 2, 4);

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.hashCode());

        assertEquals(obj1.hashCode(), obj2.hashCode());

        Assert.assertFalse(obj1.hashCode() == obj3.hashCode());
    }


    @Test
    public void hashCodeToHashSet() {
        ObjectEquals obj1 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj2 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj3 = new ObjectEquals(1, 2, 4);

        Set<ObjectEquals> set = new HashSet<>();
        set.add(obj1);
        set.add(obj2);
        set.add(obj3);

        Assert.assertEquals(2, set.size());
        assertEquals(obj1, set.toArray()[0]);
        assertEquals(obj3, set.toArray()[1]);
    }

    @Test
    public void hashCodeOfCustom() {
        ObjectEquals obj1 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj2 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj3 = new ObjectEquals(1, 2, 4);

        System.out.println(obj1.hashCodeOfCustom());
        System.out.println(obj2.hashCodeOfCustom());
        System.out.println(obj3.hashCodeOfCustom());

        assertEquals(obj1.hashCodeOfCustom(), obj2.hashCodeOfCustom());

        Assert.assertFalse(obj1.hashCodeOfCustom() == obj3.hashCodeOfCustom());
    }

    @Test
    public void hashCodeOfSuper() {
        ObjectEquals obj1 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj2 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj3 = new ObjectEquals(1, 2, 4);

        System.out.println(obj1.hashCodeOfSuper());
        System.out.println(obj2.hashCodeOfSuper());
        System.out.println(obj3.hashCodeOfSuper());

        Assert.assertFalse(obj1.hashCodeOfSuper() == obj2.hashCodeOfSuper());

        Assert.assertFalse(obj1.hashCodeOfSuper() == obj3.hashCodeOfSuper());
    }

    @Test
    public void toStringOfCustom() {
        ObjectEquals obj1 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj2 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj3 = new ObjectEquals(1, 2, 4);

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        System.out.println(obj3.toString());
    }

    @Test
    public void toStringOfSuper() {
        ObjectEquals obj1 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj2 = new ObjectEquals(1, 2, 3);
        ObjectEquals obj3 = new ObjectEquals(1, 2, 4);

        System.out.println(obj1.toStringOfSuper());
        System.out.println(obj2.toStringOfSuper());
        System.out.println(obj3.toStringOfSuper());
    }
}