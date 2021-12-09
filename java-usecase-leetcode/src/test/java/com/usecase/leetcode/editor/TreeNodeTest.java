package com.usecase.leetcode.editor;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {

    @Test
    public void testLeft() {
        TreeNode node = new TreeNode(1).left(2).left(3);

        assertThat(node.val, Matchers.is(3));
        assertThat(node.parent.val, Matchers.is(2));
        assertThat(node.root.val, Matchers.is(1));
    }

    @Test
    public void testRight() {
        TreeNode node = new TreeNode(1).right(2).right(3);
        assertThat(node.val, Matchers.is(3));
        assertThat(node.parent.val, Matchers.is(2));
        assertThat(node.root.val, Matchers.is(1));

        node = new TreeNode(1).left(2).left(3).parent.right(4).root.right(5).right(6);
        assertThat(node.val, Matchers.is(6));
        assertThat(node.parent.val, Matchers.is(5));
        assertThat(node.root.val, Matchers.is(1));
    }

    @Test
    public void testToString() {
        TreeNode node = new TreeNode(1).left(2).left(3).parent.right(4).root.right(5).right(6);
        System.out.println(node.root);
    }
}