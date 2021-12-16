package com.usecase.leetcode.editor.tree.cn654;

import com.usecase.leetcode.editor.TreeNode;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructMaximumBinaryTreeSolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void constructMaximumBinaryTreeRoot() {
        TreeNode node = solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

        assertThat(node.val, Matchers.is(6));
    }

    @Test
    public void constructMaximumBinaryTree() {
        TreeNode node = solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

        assertThat(node.val, Matchers.is(6));

        assertThat(node.left.val, Matchers.is(3));
        assertThat(node.left.right.val, Matchers.is(2));
        assertThat(node.left.right.right.val, Matchers.is(1));

        assertThat(node.right.val, Matchers.is(5));
        assertThat(node.right.left.val, Matchers.is(0));
    }
}