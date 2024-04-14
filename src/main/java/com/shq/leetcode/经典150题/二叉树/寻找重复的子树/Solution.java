package com.shq.leetcode.经典150题.二叉树.寻找重复的子树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<String, Integer> treeToCount = new HashMap<>();

    List<TreeNode> res = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    // 序列化子树
    String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);

        String val = left + "," + right + "," + root.val;
        Integer count = treeToCount.getOrDefault(val,0);
        if (count == 1) {
            res.add(root);
        }
        treeToCount.put(val, count+1);
        return val;
    }

}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}