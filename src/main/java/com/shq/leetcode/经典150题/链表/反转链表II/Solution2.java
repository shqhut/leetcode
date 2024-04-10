package com.shq.leetcode.经典150题.链表.反转链表II;


public class Solution2 {

    /**
     * 借助外部变量记录链表尾部
     */
    ListNode tail = null;

    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head,n);
        }
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }

    /**
     * 明确递归函数定义：
     * @param head
     * @param n
     * @return
     */
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            tail = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = tail;
        return last;
    }

}
