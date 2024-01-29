package com.shq.leetcode.经典150题.链表.两数相加;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, p = dummy;
        int temp = 0;
        // 如何遍历两个链表？链表长度不一样
        while (p1 != null || p2 != null || temp != 0) {
            int val1 = 0, val2 = 0;
            if (p1 != null) {
                val1 = p1.val;
            }
            if (p2 != null) {
                val2 = p2.val;
            }
            int val = val1 + val2 + temp;
            int nodeVal = val%10;
            temp = val/10;
            p.next = new ListNode(nodeVal);
            p = p.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return dummy.next;
    }

}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}