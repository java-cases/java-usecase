package javax.lambda.interfaces;

import org.junit.Test;

import java.util.function.DoubleBinaryOperator;

import static org.junit.Assert.assertEquals;

public class DoubleBinaryOperatorTest {

    @Test
    public void apply() {
        //BinaryOperator<T> 代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
        DoubleBinaryOperator func = (x, y) -> x + y;

        Double r = func.applyAsDouble(1, 2);
        assertEquals(Double.valueOf(3), r);
    }
}
