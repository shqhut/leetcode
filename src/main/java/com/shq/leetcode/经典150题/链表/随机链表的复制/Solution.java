package com.shq.leetcode.经典150题.链表.随机链表的复制;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node pointer = dummy;
        // 使用hashmap将原结点和复制后新结点关联起来
        // 优化：map命名更见名知义
        Map<Node,Node> originToClone = new HashMap<>();
        // 遍历链表，head->p1->p2->p3->null
        for (Node p = head; p != null; p = p.next) {
            // 第一次遍历，创建出复制结点，并和原结点简历关联关系
            originToClone.put(p, new Node(p.val));
        }
        for (Node p = head; p != null; p = p.next) {
            // 构建新链表，即维护next指针以及random指针
            Node node = originToClone.get(p);
            Node nextNode = null;
            Node randomNode = null;
            if (p.next != null) {
                nextNode = originToClone.get(p.next);
            }
            if (p.random != null) {
                randomNode = originToClone.get(p.random);
            }
            node.next = nextNode;
            node.random = randomNode;
            pointer.next = node;
            pointer = pointer.next;
        }
        return dummy.next;
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
