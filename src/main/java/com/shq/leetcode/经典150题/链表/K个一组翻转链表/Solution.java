package com.shq.leetcode.经典150题.链表.K个一组翻转链表;

public class Solution {

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间[a,b)包含k个待反转元素
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足k个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 翻转前k个元素
        ListNode newHead = reverse(a, b);
        // 递归翻转后续链表并连接起来
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    /**
     * 反转区间[a,b)
     * @param a
     * @param b
     * @return 新的头结点
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回翻转后的头结点
        return pre;
    }


}

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

