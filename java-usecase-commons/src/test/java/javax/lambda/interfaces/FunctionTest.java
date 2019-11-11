package javax.lambda.interfaces;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FunctionTest {

    @Test
    public void apply() {
        //Function<T,R>  接受一个输入参数，返回一个结果。
        Function<Integer, Long> func = (x) -> Long.valueOf(x + 1);

        Long r = func.apply(2);
        assertEquals(Long.valueOf(3), r);
    }
}
