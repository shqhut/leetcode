package com.shq.leetcode.经典150题.链表.随机链表的复制;

class Solution {
    public Node copyRandomList(Node head) {
        return new Node(-1);
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
