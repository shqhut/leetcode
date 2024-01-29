package com.shq.leetcode.经典150题.链表.反转链表II;

class Solution {

    ListNode successor = null; // 后驱节点

    // 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
    // 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
    // 链表下标从1开始
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 当left=1时，相当于反转链表前right个元素
        if (left == 1) {
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    ListNode reverseN(ListNode head, int n) {
        // basecase：当n=1，反转自己
        if (n == 1 || head.next == null) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
