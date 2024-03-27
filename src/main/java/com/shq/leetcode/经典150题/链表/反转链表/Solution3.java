package com.shq.leetcode.经典150题.链表.反转链表;

public class Solution3 {

    // 利用递归，明确函数定义
    // 输入一个节点head，将「以head为起点」的链表反转，并返回反转之后的头结点；
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

}
