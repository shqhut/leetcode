package com.shq.leetcode.经典150题.链表.分隔链表;

class Solution {

    // 给你一个链表的头节点head和一个特定值x，请你对链表进行分隔，使得所有小于x的节点都出现在大于或等于x的节点之前。
    // 你应当保留两个分区中每个节点的初始相对位置。
    // 思路：搞两个虚拟头结点，遍历链表时，将小于x的结点连接到一个虚拟头结点dummy1上，将大于等于x的结点连接到虚拟头结点dummy2上；
    // 注意：要防止链表成环，维护好结点next指针
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2, p3 = head;
        while (p3 != null) {
            if (p3.val < x) {
                p1.next = p3;
                p1 = p1.next;
                p1.next = null;
            }else {
                p2.next = p3;
                p2 = p2.next;
                p2.next = null;
            }
            p3 = p3.next;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        // [1,4,3,2,5,2] x=3
        Solution solution = new Solution();
        ListNode n5 = new ListNode(1);
        ListNode n4 = new ListNode(1, n5);
        ListNode n3 = new ListNode(1,n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = new ListNode(1, n1);
        solution.partition(head,3);
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


