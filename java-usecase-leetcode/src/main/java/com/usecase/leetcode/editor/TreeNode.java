package com.usecase.leetcode.editor;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;

    public TreeNode() {
        this.root = this;
    }

    public TreeNode(int val) {
        this.val = val;
        this.root = this;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.root = this;

        this.left = left;
        this.left.parent = this;
        this.right = right;
        this.right.parent = this;
    }

    public TreeNode left(int val) {
        this.left = new TreeNode(val);
        this.left.parent = this;
        this.left.root = this.root;
        return this.left;
    }

    public TreeNode right(int val) {
        this.right = new TreeNode(val);
        this.right.parent = this;
        this.right.root = this.root;
        return this.right;
    }

    @Override
    public String toString() {
        TreeNode node = this;
        List<Integer> nodeValues = new LinkedList<>();

        preorder(node, nodeValues);

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < nodeValues.size() - 1; i++) {
            text.append(nodeValues.get(i).intValue()).append(",");
        }
        text.append(nodeValues.get(nodeValues.size() - 1).intValue());

        return text.toString();
    }

    private void preorder(TreeNode node, List<Integer> nodeValues) {
        if (node == null) {
            return;
        }

        nodeValues.add(node.val);
        preorder(node.left, nodeValues);
        preorder(node.right, nodeValues);
    }
}
