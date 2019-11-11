package javax.lang.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDemicalx {

    public final static int ROUND_UP = 0;

    public final static int ROUND_DOWN = 1;

    public final static int ROUND_CEILING = 2;

    public final static int ROUND_FLOOR = 3;

    public final static int ROUND_HALF_UP = 4;

    public final static int ROUND_HALF_DOWN = 5;

    public final static int ROUND_HALF_EVEN = 6;

    public final static int ROUND_UNNECESSARY = 7;


    private BigDecimal big;

    public BigDemicalx(BigDecimal big) {
        this.big = big;
    }

    public static BigDecimal newBigDecimal(String val) {
        return new BigDecimal(val);
    }

    public static BigDecimal newBigDecimal(String val, MathContext mc) {
        return new BigDecimal(val, mc);
    }

    public static BigDecimal newBigDecimal(int val) {
        return new BigDecimal(val);
    }

    public static BigDecimal newBigDecimal(int val, MathContext mc) {
        return new BigDecimal(val, mc);
    }

    public static BigDecimal newBigDecimal(BigInteger val) {
        return new BigDecimal(val);
    }

    public static BigDecimal newBigDecimal(BigInteger val, MathContext mc) {
        return new BigDecimal(val, mc);
    }

    public static BigDecimal newBigDecimal(double val) {
        return new BigDecimal(val);
    }

    public static BigDecimal newBigDecimal(double val, MathContext mc) {
        return new BigDecimal(val, mc);
    }

    public static BigDecimal valueOf(long val) {
        return BigDecimal.valueOf(val);
    }

    public static BigDecimal valueOf(double val) {
        return BigDecimal.valueOf(val);
    }

    public BigDecimal add(BigDecimal augend) {
        return big.add(augend);
    }

    public BigDecimal subtract(BigDecimal subtrahend) {
        return big.subtract(subtrahend);
    }

    public BigDecimal multiply(BigDecimal multiplicand) {
        return big.multiply(multiplicand);
    }

    public BigDecimal divide(BigDecimal divisor) {
        return big.divide(divisor);
    }

    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        return big.divide(divisor, scale, roundingMode);
    }

    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        return big.divide(divisor, roundingMode);
    }

    public BigDecimal remainder(BigDecimal divisor) {
        return big.remainder(divisor);
    }

    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        return big.divideAndRemainder(divisor);
    }

    public BigDecimal pow(int n) {
        return big.pow(n);
    }

    public BigDecimal abs() {
        return big.abs();
    }

    public BigDecimal negate() {
        return big.negate();
    }

    public BigDecimal plus() {
        return big.plus();
    }

    public int signum() {
        return big.signum();
    }

    public int scale() {
        return big.scale();
    }

    public int precision() {
        return big.precision();
    }

    public BigInteger unscaledValue() {
        return big.unscaledValue();
    }

    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        return big.setScale(newScale, roundingMode);
    }

    public BigDecimal setScale(int newScale) {
        return big.setScale(newScale);
    }

    public BigDecimal movePointLeft(int n) {
        return big.movePointLeft(n);
    }

    public BigDecimal movePointRight(int n) {
        return big.movePointRight(n);
    }

    public BigDecimal scaleByPowerOfTen(int n) {
        return big.scaleByPowerOfTen(n);
    }

    public BigDecimal stripTrailingZeros() {
        return big.stripTrailingZeros();
    }

    public int compareTo(BigDecimal val) {
        return big.compareTo(val);
    }

    public BigDecimal min(BigDecimal val) {
        return big.min(val);
    }

    public BigDecimal max(BigDecimal val) {
        return big.max(val);
    }

    public String toEngineeringString() {
        return big.toEngineeringString();
    }

    public String toPlainString() {
        return big.toPlainString();
    }

    public BigInteger toBigInteger() {
        return big.toBigInteger();
    }

    public BigInteger toBigIntegerExact() {
        return big.toBigIntegerExact();
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

    public BigDecimal ulp() {
        return big.ulp();
    }
}
