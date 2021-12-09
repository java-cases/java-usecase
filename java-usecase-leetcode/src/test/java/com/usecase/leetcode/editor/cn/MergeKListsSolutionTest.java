package com.usecase.leetcode.editor.cn;

import com.usecase.leetcode.editor.ListNode;
import com.usecase.leetcode.editor.TreeNode;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class MergeKListsSolutionTest {

    @Test
    public void mergeKLists() {
        ListNode[] lists = new ListNode[]{new ListNode(1).next(4).next(5).head,
                new ListNode(1).next(3).next(4).head,
                new ListNode(2).next(6).head};

        /*
        Solution solution = new Solution();
        ListNode mergedNode = solution.mergeKLists(lists);

        System.out.println(mergedNode);

        while (mergedNode != null && mergedNode.next != null) {
            assertThat(mergedNode.val <= mergedNode.next.val, Matchers.is(true));
            mergedNode = mergedNode.next;
        }
         */
    }
}