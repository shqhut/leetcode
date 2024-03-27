package com.shq.leetcode.经典150题.链表.反转链表;

public class Solution2 {

    ListNode pummy = new ListNode(-1);
    ListNode p = pummy;

    public ListNode reverseList(ListNode head) {
        traverse(head);
        return pummy.next;
    }

    void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        traverse(head.next);
        p.next = new ListNode(head.val);
        p = p.next;
    }

}
