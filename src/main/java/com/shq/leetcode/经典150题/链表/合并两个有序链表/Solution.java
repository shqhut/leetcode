package com.shq.leetcode.经典150题.链表.合并两个有序链表;

/**
 * 拉链法
 */
public class Solution {

    // 将两个升序链表合并为一个新的升序链表并返回。
    // 新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 定义一个虚拟链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = list1, p2 = list2;
        // 边界情况考虑，同时遍历两个链表，当一个链表排序完成，另一个链表剩下的元素可以直接连接到后面
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            // p指针不断前进
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
