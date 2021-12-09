package com.usecase.leetcode.editor;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListNodeTest {

    @Test
    public void testNext() {
        ListNode node = new ListNode(1).next(4).next(5);

        assertThat(node.val, Matchers.is(5));
        assertThat(node.head.val, Matchers.is(1));
    }

    @Test
    public void testToString() {
        System.out.println(new ListNode(1).next(2).next(3).next(4).next(5).head);
    }
}