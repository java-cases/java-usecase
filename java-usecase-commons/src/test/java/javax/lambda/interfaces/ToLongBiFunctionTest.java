package javax.lambda.interfaces;

import org.junit.Test;

import java.util.function.ToLongBiFunction;

import static org.junit.Assert.assertEquals;

public class ToLongBiFunctionTest {

    @Test
    public void applyAsLong() {
        //ToLongBiFunction<T,U> 接受2个输入参数，返回一个long类型结果。
        ToLongBiFunction<Integer, Long> func = (x, y) -> x + y;

        Long r = func.applyAsLong(1, 2L);
        assertEquals(true, r == 3L);
    }
}
