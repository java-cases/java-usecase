package javax.lang.numbers;

import java.math.BigInteger;

public class BigIntegerx {

    private BigInteger big;

    public static final BigInteger ZERO = valueOf(0);

    public static final BigInteger ONE = valueOf(1);

    public static final BigInteger TEN = valueOf(10);

    public BigIntegerx(BigInteger big) {
        this.big = big;
    }

    public static BigInteger newBigInteger(String val, int radix) {
        return new BigInteger(val, radix);
    }

    public static BigInteger newBigInteger(String val) {
        return new BigInteger(val, 10);
    }

    public static BigInteger valueOf(long val) {
        return BigInteger.valueOf(val);
    }

    public BigInteger add(BigInteger val) {
        return big.add(val);
    }

    public BigInteger subtract(BigInteger val) {
        return big.subtract(val);
    }

    public BigInteger multiply(BigInteger val) {
        return big.multiply(val);
    }


    public BigInteger divide(BigInteger val) {
        return big.divide(val);
    }

    public BigInteger[] divideAndRemainder(BigInteger val) {
        return big.divideAndRemainder(val);
    }

    public BigInteger remainder(BigInteger val) {
        return big.remainder(val);
    }

    public BigInteger pow(int exponent) {
        return big.pow(exponent);
    }

    public BigInteger abs() {
        return big.abs();
    }

    public BigInteger negate() {
        return big.negate();
    }

    public int signum() {
        return big.signum();
    }

    public BigInteger mod(BigInteger m) {
        return big.mod(m);
    }

    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        return big.modPow(exponent, m);
    }

    public BigInteger modInverse(BigInteger m) {
        return big.modInverse(m);
    }

    public BigInteger shiftLeft(int n) {
        return big.shiftLeft(n);
    }

    public BigInteger shiftRight(int n) {
        return big.shiftRight(n);
    }

    public BigInteger and(BigInteger val) {
        return big.and(val);
    }

    public BigInteger or(BigInteger val) {
        return big.or(val);
    }

    public BigInteger xor(BigInteger val) {
        return big.xor(val);
    }

    public BigInteger not() {
        return big.not();
    }

    public BigInteger andNot(BigInteger val) {
        return big.andNot(val);
    }

    public boolean testBit(int n) {
        return big.testBit(n);
    }

    public BigInteger setBit(int n) {
        return big.setBit(n);
    }

    public BigInteger clearBit(int n) {
        return big.clearBit(n);
    }

    public BigInteger flipBit(int n) {
        return big.flipBit(n);
    }

    public int getLowestSetBit() {
        return big.getLowestSetBit();
    }

    public int bitLength() {
        return big.bitLength();
    }

    public int bitCount() {
        return big.bitCount();
    }

    public boolean isProbablePrime(int certainty) {
        return big.isProbablePrime(certainty);
    }

    public int compareTo(BigInteger val) {
        return big.compareTo(val);
    }

    public BigInteger min(BigInteger val) {
        return big.min(val);
    }

    public BigInteger max(BigInteger val) {
        return big.max(val);
    }

    public byte[] toByteArray() {
        return big.toByteArray();
    }

    public byte byteValueExact() {
        return big.byteValueExact();
    }

    public int intValue() {
        return big.intValue();
    }

    public int intValueExact() {
        return big.intValueExact();
    }

    public long longValue() {
        return big.longValue();
    }

    public long longValueExact() {
        return big.longValueExact();
    }

    public float floatValue() {
        return big.floatValue();
    }

    public short shortValueExact() {
        return big.shortValueExact();
    }

    public double doubleValue() {
        return big.doubleValue();
    }

}
