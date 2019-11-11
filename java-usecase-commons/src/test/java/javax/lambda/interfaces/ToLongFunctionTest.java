package javax.lambda.interfaces;

import org.junit.Test;

import java.util.function.ToLongFunction;

import static org.junit.Assert.assertEquals;

public class ToLongFunctionTest {

    @Test
    public void applyAsLong() {
        //ToDoubleFunction<T> 接受一个输入参数，返回一个double类型结果
        ToLongFunction<Integer> func = (x) -> x + 1;

        Long r = func.applyAsLong(1);
        assertEquals(true, r == 2L);
    }
}
