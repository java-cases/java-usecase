package com.usecase.leetcode.editor.list.cn876;

import com.usecase.leetcode.editor.ListNode;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiddleNodeSolutionTest {

    @Test
    public void middleNode() {
        MiddleNodeSolution solution = new MiddleNodeSolution();

        ListNode node = new ListNode(1).next(2).next(3).next(4).next(5).head;
        ListNode middleNode = solution.middleNode(node);
        assertThat(middleNode.val, Matchers.is(3));

        node = new ListNode(1).next(2).next(3).next(4).next(5).next(6).head;
        middleNode = solution.middleNode(node);
        assertThat(middleNode.val, Matchers.is(4));
    }
}