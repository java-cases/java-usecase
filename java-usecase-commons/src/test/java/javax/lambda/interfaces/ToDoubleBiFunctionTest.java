package javax.lambda.interfaces;

import org.junit.Test;

import java.util.function.ToDoubleBiFunction;

import static org.junit.Assert.assertEquals;

public class ToDoubleBiFunctionTest {

    @Test
    public void applyAsDouble() {
        //ToDoubleBiFunction<T,U> 接受两个输入参数，返回一个double类型结果
        ToDoubleBiFunction<Integer, Long> func = (x, y) -> x + y;

        Double r = func.applyAsDouble(1, 2L);
        assertEquals(Double.valueOf(3), r);
    }
}
