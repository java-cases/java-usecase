package javax.lang.generic.compare;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void compareToNext() {
        Node<Integer> next = new Node(20, null);
        Node<Integer> node = new Node(10, next);

        Assert.assertEquals(-1, node.compareToNext());

        Assert.assertEquals(1, next.compareToNext());
    }

    @Test
    public void compareTo() {
        Node<Integer> next = new Node(20, null);
        Node<Integer> node = new Node(10, next);

        Assert.assertEquals(1, node.compareTo(null));

        Assert.assertEquals(1, next.compareTo(node));

        Assert.assertEquals(0, node.compareTo(node));

        Assert.assertEquals(-1, node.compareTo(next));
    }
}