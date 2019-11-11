package javax.lang.generic;

import org.junit.Assert;
import org.junit.Test;

public class ObjectNodeTest {

    @Test
    public void objectNode() {
        ObjectNode next = new ObjectNode(20, null);
        ObjectNode node = new ObjectNode(10, next);

        Assert.assertEquals(true, (Integer) node.getData() == 10);

        Assert.assertEquals(next, node.getNext());
    }
}