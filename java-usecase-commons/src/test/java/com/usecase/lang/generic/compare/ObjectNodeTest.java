package com.usecase.lang.generic.compare;

import org.junit.Assert;
import org.junit.Test;

public class ObjectNodeTest {

    @Test
    public void compareToNext() {
        ObjectNode next = new ObjectNode(20, null);
        ObjectNode node = new ObjectNode(10, next);

        Assert.assertEquals(-1, node.compareToNext());

        Assert.assertEquals(1, next.compareToNext());
    }

    @Test
    public void compareTo() {
        ObjectNode next = new ObjectNode(20, null);
        ObjectNode node = new ObjectNode(10, next);

        Assert.assertEquals(1, node.compareTo(null));

        Assert.assertEquals(1, next.compareTo(node));

        Assert.assertEquals(0, node.compareTo(node));

        Assert.assertEquals(-1, node.compareTo(next));
    }

}