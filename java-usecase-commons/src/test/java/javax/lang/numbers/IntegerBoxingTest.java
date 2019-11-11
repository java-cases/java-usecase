package javax.lang.numbers;

import org.junit.Assert;
import org.junit.Test;

public class IntegerBoxingTest {

    @Test
    public void boxingByNewObject() {
        Integer x = new Integer(1);
        Integer y = new Integer(1);

        Assert.assertEquals(false, x == y);
        Assert.assertEquals(true, x.equals(y));

        Assert.assertEquals(true, x == 1);
        Assert.assertEquals(true, x.equals(1));

        Assert.assertEquals(true, y == 1);
        Assert.assertEquals(true, y.equals(1));
    }

    @Test
    public void boxing() {
        Integer x = 1;
        Integer y = 1;

        Assert.assertEquals(true, x == y);
        Assert.assertEquals(true, x.equals(y));

        Assert.assertEquals(true, x == 1);
        Assert.assertEquals(true, x.equals(1));

        Assert.assertEquals(true, y == 1);
        Assert.assertEquals(true, y.equals(1));
    }

    @Test
    public void boxingByValueOf() {
        Integer x = Integer.valueOf(1);
        Integer y = Integer.valueOf(1);

        Assert.assertEquals(true, x == y);
        Assert.assertEquals(true, x.equals(y));

        Assert.assertEquals(true, x == 1);
        Assert.assertEquals(true, x.equals(1));

        Assert.assertEquals(true, y == 1);
        Assert.assertEquals(true, y.equals(1));
    }

    @Test
    public void boxingAndValueOf() {
        Integer x = 1;
        Integer y = Integer.valueOf(1);

        Assert.assertEquals(true, x == y);
        Assert.assertEquals(true, x.equals(y));

        Assert.assertEquals(true, x == 1);
        Assert.assertEquals(true, x.equals(1));

        Assert.assertEquals(true, y == 1);
        Assert.assertEquals(true, y.equals(1));
    }

    @Test
    public void unboxing() {
        Integer x = 1;
        Integer y = x + 1;

        Assert.assertEquals(true, y == 2);
        Assert.assertEquals(true, y.equals(2));
    }

    @Test
    public void unboxingByIntValue() {
        Integer x = 1;
        Integer y1 = x + 1;
        Integer y2 = Integer.valueOf(x.intValue() + 1);

        Assert.assertEquals(true, y1 == y2);
        Assert.assertEquals(true, y1.equals(y2));

        Assert.assertEquals(true, y1 == 2);
        Assert.assertEquals(true, y1.equals(2));

        Assert.assertEquals(true, y2 == 2);
        Assert.assertEquals(true, y2.equals(2));
    }
}