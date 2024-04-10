package com.shq.leetcode.经典150题.链表.反转链表II;

public class Solution3 {

    ListNode tail = null;

    // 明确递归函数定义：翻转以head为头结点，m到n部分的链表，并返回新的头结点
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 0) {
            // 相当于翻转前n个链表 base case
            return reverseN(head,n);
        }
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }

    //明确函数定义：翻转前N个结点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1 || head.next == null) {
            tail = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = tail;
        return last;
    }

}
