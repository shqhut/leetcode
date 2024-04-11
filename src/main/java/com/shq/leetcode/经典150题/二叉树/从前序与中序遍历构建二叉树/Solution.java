package com.shq.leetcode.经典150题.二叉树.从前序与中序遍历构建二叉树;

import java.util.HashMap;

public class Solution {

    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder,0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    // 定义：如果前序遍历数组 preorder[preStart,preEnd]，中序遍历数组 inorder[inStart,inEnd]构建二叉树
    // 返回根节点
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的第一个元素为根结点元素
        int rootVal = preorder[preStart];
        // rootVal在中序遍历的索引（无重复元素）
        int rootIndex = valToIndex.get(rootVal);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,preStart+1,preStart+leftSize,
                            inorder,inStart,rootIndex-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,
                            inorder,rootIndex+1,inEnd);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        solution.buildTree(preorder,inorder);
    }

}


// Definition for a binary tree node.
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

