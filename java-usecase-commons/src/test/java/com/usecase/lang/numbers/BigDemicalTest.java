package com.usecase.lang.numbers;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class BigDemicalTest {

    @Test
    public void calculateWithBigDemical() {
        System.out.println("0.09 + 0.01=" + (0.09 + 0.01));
        BigDecimal big = new BigDecimal(0.09).add(new BigDecimal(0.01));
        System.out.println("BigDecimal:" + big);
        System.out.println("BigDecimal.doubleValue():" + big.doubleValue());

        System.out.println("1.0 - 0.32=" + (1.0 - 0.32));
        big = new BigDecimal(1.0).subtract(new BigDecimal(0.32));
        System.out.println("BigDecimal:" + big);
        System.out.println("BigDecimal.doubleValue():" + big.doubleValue());

        System.out.println("1.015 * 100=" + (1.015 * 100));
        big = new BigDecimal(1.015).multiply(new BigDecimal(100));
        System.out.println("BigDecimal:" + big);
        System.out.println("BigDecimal.doubleValue():" + big.doubleValue());

        System.out.println("1.301 / 100=" + (1.301 / 100));
        big = new BigDecimal(1.301).divide(new BigDecimal(100));
        System.out.println("BigDecimal:" + big);
        System.out.println("BigDecimal.doubleValue():" + big.doubleValue());

        //四舍五入,保留3位有效数字
        System.out.println("1.301 / 100=" + (1.301 / 100));
        big = new BigDecimal(1.301).divide(new BigDecimal(100),
                3, BigDecimal.ROUND_HALF_UP);
        System.out.println("BigDecimal:" + big);
        System.out.println("BigDecimal.doubleValue():" + big.doubleValue());

        //四舍五入,保留8位有效数字
        System.out.println("1.301 / 100=" + (1.301 / 100));
        big = new BigDecimal(1.301).divide(new BigDecimal(100),
                8, BigDecimal.ROUND_HALF_UP);
        System.out.println("BigDecimal:" + big);
        System.out.println("BigDecimal.doubleValue():" + big.doubleValue());

        System.out.println("1.0 - 0.12=" + (1.0 - 0.12));
        big = new BigDecimal(1.0).subtract(new BigDecimal(0.12));
        System.out.println("BigDecimal:" + big);
        System.out.println("BigDecimal.doubleValue():" + big.doubleValue());
    }

    @Test
    public void newBigDecimalFromInt() {
        BigDecimal big = new BigDecimal(10);

        Assert.assertEquals(true, big.intValue() == 10);
    }

    @Test
    public void newBigDecimalFromIntMc() {
        BigDecimal big = new BigDecimal(10, MathContext.UNLIMITED);

        Assert.assertEquals(true, big.intValue() == 10);
    }

    @Test
    public void newBigDecimalFromLong() {
        BigDecimal big = new BigDecimal(10L);

        Assert.assertEquals(true, big.longValue() == 10L);
    }

    @Test
    public void newBigDecimalFromLongMc() {
        BigDecimal big = new BigDecimal(10L, MathContext.UNLIMITED);

        Assert.assertEquals(true, big.longValue() == 10L);
    }

    @Test
    public void newBigDecimalFromDouble() {
        BigDecimal big = new BigDecimal(10.00d);

        Assert.assertEquals(true, big.doubleValue() == 10.00d);
    }

    @Test
    public void newBigDecimalFromDoubleMc() {
        BigDecimal big = new BigDecimal(10.00d, MathContext.UNLIMITED);

        Assert.assertEquals(true, big.doubleValue() == 10.00d);
    }

    @Test
    public void newBigDecimalFromBigInteger() {
        BigDecimal big = new BigDecimal(BigInteger.valueOf(10));

        Assert.assertEquals(true, big.intValue() == 10);
    }

    @Test
    public void newBigDecimalFromBigIntegerMc() {
        BigDecimal big = new BigDecimal(BigInteger.valueOf(10), MathContext.UNLIMITED);

        Assert.assertEquals(true, big.intValue() == 10);
    }

    @Test
    public void newBigDecimal() {
        BigDecimal big = new BigDecimal("10.00");

        Assert.assertEquals(true, big.intValue() == 10);
    }

    @Test
    public void newBigDecimalMc() {
        BigDecimal big = new BigDecimal("10.00", MathContext.UNLIMITED);

        Assert.assertEquals(true, big.intValue() == 10);
    }

    @Test
    public void valueOfLong() {
        BigDecimal big = BigDecimal.valueOf(10L);

        Assert.assertEquals(true, big.longValue() == 10);
    }

    @Test
    public void valueOfDouble() {
        BigDecimal big = BigDecimal.valueOf(10.00d);

        Assert.assertEquals(true, big.doubleValue() == 10.00d);
    }

    @Test
    public void add() {
        //不可变的、任意精度的有符号十进制数,可以解决数据丢失问题。
        BigDecimal big1 = new BigDecimal("0.09");
        BigDecimal big2 = new BigDecimal("0.01");

        BigDecimal big3 = big1.add(big2);
        System.out.println(big3);

        Assert.assertEquals(true, big3.doubleValue() == 0.10d);
    }

    @Test
    public void subtract() {
        BigDecimal big1 = new BigDecimal("1.0");
        BigDecimal big2 = new BigDecimal("0.32");

        BigDecimal big3 = big1.subtract(big2);
        System.out.println(big3);

        Assert.assertEquals(true, big3.doubleValue() == 0.68d);
    }

    @Test
    public void multiply() {
        BigDecimal big1 = new BigDecimal("1.015");
        BigDecimal big2 = new BigDecimal("100");

        BigDecimal big3 = big1.multiply(big2);
        System.out.println(big3);

        Assert.assertEquals(true, big3.doubleValue() == 101.5d);
    }

    @Test
    public void divide() {
        BigDecimal big1 = new BigDecimal("1.301");
        BigDecimal big2 = new BigDecimal("100");

        BigDecimal big3 = big1.divide(big2);
        System.out.println(big3);

        Assert.assertEquals(true, big3.doubleValue() == 0.01301d);
    }

    @Test
    public void divideWithRoundingMode() {
        BigDecimal big1 = new BigDecimal("1.301");
        BigDecimal big2 = new BigDecimal("100");

        BigDecimal big3 = big1.divide(big2, 3, BigDecimal.ROUND_HALF_UP);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.013d);

        big3 = big1.divide(big2, 8, BigDecimal.ROUND_HALF_UP);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.01301000d);

        big3 = big1.divide(big2, 3, BigDecimal.ROUND_FLOOR);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.013d);

        big3 = big1.divide(big2, 3, BigDecimal.ROUND_UP);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.014d);

        big3 = big1.divide(big2, 3, BigDecimal.ROUND_DOWN);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.013d);

        big3 = big1.divide(big2, 3, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.013d);

        big3 = big1.divide(big2, 3, BigDecimal.ROUND_CEILING);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.014d);

        big3 = big1.divide(big2, 3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(big3);
        Assert.assertEquals(true, big3.doubleValue() == 0.013d);
    }
}