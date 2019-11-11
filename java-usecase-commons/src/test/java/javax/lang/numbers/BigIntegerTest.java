package javax.lang.numbers;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class BigIntegerTest {

    @Test
    public void calculateWithBigDemical() {
        System.out.println("100 + 50=" + (100 + 50));
        BigInteger big = BigInteger.valueOf(100).add(BigInteger.valueOf(50));
        System.out.println("BigInteger:" + big);
        System.out.println("BigInteger.doubleValue():" + big.doubleValue());

        System.out.println("100 - 50=" + (100 - 50));
        big = BigInteger.valueOf(100).subtract(BigInteger.valueOf(50));
        System.out.println("BigInteger:" + big);
        System.out.println("BigInteger.doubleValue():" + big.doubleValue());

        System.out.println("100 * 50=" + (100 * 50));
        big = BigInteger.valueOf(100).multiply(BigInteger.valueOf(50));
        System.out.println("BigInteger:" + big);
        System.out.println("BigInteger.doubleValue():" + big.doubleValue());

        System.out.println("100 / 15=" + (100 / 15));
        big = BigInteger.valueOf(100).divide(BigInteger.valueOf(15));
        System.out.println("BigInteger:" + big);
        System.out.println("BigInteger.doubleValue():" + big.doubleValue());
    }


    @Test
    public void newBigIntegerFromString() {
        BigInteger big = new BigInteger("10");

        Assert.assertEquals(10L, big.longValue());
    }

    @Test
    public void newBigIntegerFromString10Radix() {
        BigInteger big = new BigInteger("10", 10);

        Assert.assertEquals(10L, big.longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void newBigIntegerFromString2RadixInvalid() {
        BigInteger big = new BigInteger("211", 2);
    }

    @Test
    public void newBigIntegerFromString2Radix() {
        BigInteger big = new BigInteger("111", 2);

        Assert.assertEquals(7L, big.longValue());
    }

    @Test
    public void newBigIntegerFromString8Radix() {
        BigInteger big = new BigInteger("111", 8);

        Assert.assertEquals(73L, big.longValue());
    }

    @Test
    public void newBigIntegerFromString16Radix() {
        BigInteger big = new BigInteger("111", 16);

        Assert.assertEquals(273L, big.longValue());
    }

    @Test
    public void valueOfLong() {
        BigInteger big = BigInteger.valueOf(10L);

        Assert.assertEquals(10L, big.longValue());
    }

    @Test
    public void add() {
        BigInteger big1 = new BigInteger("10000000000000");
        BigInteger big2 = new BigInteger("10000000000000");

        BigInteger big3 = big1.add(big2);
        System.out.println(big3);

        Assert.assertEquals(20000000000000L, big3.longValue());
    }

    @Test
    public void subtract() {
        BigInteger big1 = new BigInteger("20000000000000");
        BigInteger big2 = new BigInteger("10000000000000");

        BigInteger big3 = big1.subtract(big2);
        System.out.println(big3);

        Assert.assertEquals(10000000000000L, big3.longValue());
    }

    @Test
    public void multiply() {
        BigInteger big1 = new BigInteger("10000000000000");
        BigInteger big2 = new BigInteger("100000");

        BigInteger big3 = big1.multiply(big2);
        System.out.println(big3);

        Assert.assertEquals(1000000000000000000L, big3.longValue());
    }

    @Test
    public void divide() {
        BigInteger big1 = new BigInteger("20000000000000");
        BigInteger big2 = new BigInteger("15000000000000");

        BigInteger big3 = big1.divide(big2);
        System.out.println(big3);

        Assert.assertEquals(1L, big3.longValue());
    }

    @Test
    public void remainder() {
        BigInteger big1 = new BigInteger("20000000000000");
        BigInteger big2 = new BigInteger("15000000000000");

        BigInteger big3 = big1.remainder(big2);
        System.out.println(big3);

        Assert.assertEquals(5000000000000L, big3.longValue());
    }

    @Test
    public void divideAndRemainder() {
        BigInteger big1 = new BigInteger("20000000000000");
        BigInteger big2 = new BigInteger("15000000000000");

        BigInteger[] bigs = big1.divideAndRemainder(big2);
        System.out.println(Arrays.toString(bigs));

        Assert.assertEquals(1L, bigs[0].longValue());
        Assert.assertEquals(5000000000000L, bigs[1].longValue());
    }

}