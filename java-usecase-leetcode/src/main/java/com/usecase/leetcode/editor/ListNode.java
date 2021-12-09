package com.usecase.leetcode.editor;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode head;

    public ListNode() {
        this.head = this;
    }

    public ListNode(int val) {
        this.val = val;
        this.head = this;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.head = this;

        this.next = next;
        this.next.head = this.head;
    }

    public ListNode next(int val) {
        this.next = new ListNode(val);
        this.next.head = this.head;
        return this.next;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        ListNode node = this;

        while (node != null) {
            text.append(node.val);
            text.append(node.next != null ? "," : "");
            node = node.next;
        }

        return text.toString();
    }
}
