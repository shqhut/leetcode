package com.shq.leetcode.经典150题.链表.旋转链表;

class Solution {

    // 题目：给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
    // 思路：
    // 1->2->3->4->5 每个结点移动2个位置  4->5->1->2->3
    // k可能超过链表长度，假设链表长度为n 真正移动的长度应该是i=k%n
    // 向右移动i个位置，相当于将倒数第i个结点，正数n-i+1个结点放到链表头结点 n-i+1->n-i+2->...->tail->head->2->..->n-i->null
    // 最终将head指向结点n-i+1
    // 代码实现思路：先遍历一遍链表，获取链表长度，同时获取尾结点，p->tail；
    // 再遍历链表找到第n-i个结点，n-i的next指针指向null，即n-i->null，将原链表的尾结点的next指针指向尾head结点，即p->head;
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // 获取链表长度
        ListNode p = head,p1 = head;
        int len = 1;
        // 遍历完成，即获得了链表长度，又将p指向了链表的tail结点
        while (p.next != null) {
            p = p.next;
            len++;
        }
        if (len == 1) {
            return head;
        }
        // 真正移动的位置
        int i = k%len;
        // 再遍历链表，获取第len-i个结点，链表需要前进len-i-1步
        for (int j = 1; j < len - i; j++) {
            // 循环结束，p1指向了第len-i个结点
            p1 = p1.next;
        }
        ListNode newHead = p1.next;
        p1.next = null;
        p.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        solution.rotateRight(head, 2);
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

