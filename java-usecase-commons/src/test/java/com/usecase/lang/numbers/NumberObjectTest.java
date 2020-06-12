package com.usecase.lang.numbers;

import org.junit.Assert;
import org.junit.Test;

public class NumberObjectTest {

    @Test
    public void longValue() {
        Integer num = new Integer(10);
        Long l = num.longValue();

        Assert.assertEquals(true, l == 10L);
    }

    @Test
    public void toBinaryString() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(10));
    }

    @Test
    public void toOctalString() {
        System.out.println(Integer.toOctalString(-1));
        System.out.println(Integer.toOctalString(0));
        System.out.println(Integer.toOctalString(1));
        System.out.println(Integer.toOctalString(10));
    }

    @Test
    public void toHexString() {
        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toHexString(0));
        System.out.println(Integer.toHexString(1));
        System.out.println(Integer.toHexString(10));
    }

    @Test
    public void toUnsignedString() {
        System.out.println(Integer.toUnsignedString(-1));
        System.out.println(Integer.toUnsignedString(0));
        System.out.println(Integer.toUnsignedString(1));
        System.out.println(Integer.toUnsignedString(10));
    }

    @Test
    public void bitCount() {
        Integer num = Integer.bitCount(100);

        System.out.println(num);
    }

    @Test
    public void reverse() {
        Integer num = Integer.reverse(1);

        System.out.println(num);
    }

    @Test
    public void reverseBytes() {
        Integer num = Integer.reverseBytes(10);

        System.out.println(Integer.toHexString(10));
        System.out.println(Integer.toHexString(num));
    }

    @Test
    public void hashCodeOfInteger() {
        Assert.assertEquals(-1, Integer.hashCode(-1));
        Assert.assertEquals(0, Integer.hashCode(0));
        Assert.assertEquals(1, Integer.hashCode(1));

        Assert.assertEquals(-1, new Integer(-1).hashCode());
        Assert.assertEquals(0, new Integer(0).hashCode());
        Assert.assertEquals(1, new Integer(1).hashCode());
    }

    @Test
    public void equalsOfInteger() {
        Assert.assertTrue(new Integer(1).equals(1));
        Assert.assertTrue(new Integer(1).equals(new Integer(1)));

        Assert.assertFalse(new Integer(1).equals(2));
        Assert.assertFalse(new Integer(1).equals(null));
        Assert.assertFalse(new Integer(1).equals(true));
        Assert.assertFalse(new Integer(1).equals(""));
        Assert.assertFalse(new Integer(1).equals("1"));
    }
}
