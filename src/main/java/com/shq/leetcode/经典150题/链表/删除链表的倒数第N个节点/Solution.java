package com.shq.leetcode.经典150题.链表.删除链表的倒数第N个节点;

public class Solution {

    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n==0) {
            return head;
        }
        // 双指针技巧（快慢指针）：假设链表 [1,2,3,4,5,6] => 1->2->3->4->5->6->null  链表长度为6
        // 删除链表倒数第n个结点，需要找到倒数n-1个结点
        ListNode fast = head, slow = head;
        int i = 0;
        while (fast.next != null) {
            if (i == n) {
                slow = slow.next;
            }
            fast = fast.next;
            i++;
        }
        // 边界情况，只有一个结点
        if (slow.next == null) {
            // slow指向最后一个结点
            return null;
        }
        // 此时slow指向倒数n-1个结点
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;
        return head;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
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
