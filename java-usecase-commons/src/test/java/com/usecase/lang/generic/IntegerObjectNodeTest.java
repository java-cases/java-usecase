package com.usecase.lang.generic;

import org.junit.Assert;
import org.junit.Test;

public class IntegerObjectNodeTest {

    @Test
    public void integerObjectNode() {
        IntegerObjectNode next = new IntegerObjectNode(20, null);
        IntegerObjectNode node = new IntegerObjectNode(10, next);

        Assert.assertEquals(true, (Integer) node.getData() == 10);

        Assert.assertEquals(next, node.getNext());
    }
}