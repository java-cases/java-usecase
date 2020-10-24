package com.usecase.lang.generic;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void node() {

        Node<Integer> next = new Node(20, null);
        Node<Integer> node = new Node(10, next);

        Assert.assertEquals(true, node.getData() == 10);

        Assert.assertEquals(next, node.getNext());
    }

    @Test
    public void integerNode() {

        Node<Integer> next = new IntegerNode(20, null);
        Node<Integer> node = new IntegerNode(10, next);

        Assert.assertEquals(true, node.getData() == 10);

        Assert.assertEquals(next, node.getNext());
    }
}