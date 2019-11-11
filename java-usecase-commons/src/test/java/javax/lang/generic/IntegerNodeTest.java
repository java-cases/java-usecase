package javax.lang.generic;

import org.junit.Assert;
import org.junit.Test;

public class IntegerNodeTest {

    @Test
    public void integerNode() {
        IntegerNode next = new IntegerNode(20, null);
        IntegerNode node = new IntegerNode(10, next);

        Assert.assertEquals(true, node.getData()==10);

        Assert.assertEquals(next, node.getNext());
    }

    @Test
    public void node() {

        Node<Integer> next = new IntegerNode(20, null);
        Node<Integer> node = new IntegerNode(10, next);

        Assert.assertEquals(true, node.getData()==10);

        Assert.assertEquals(next, node.getNext());
    }
}