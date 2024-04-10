package com.shq.leetcode.经典150题.链表.反转链表;

public class Solution4 {

    public ListNode reverseList(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head;
        while (cur != null) {
            nxt = cur.next;
            // 逐个结点翻转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}
