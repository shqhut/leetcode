package com.shq.leetcode.labuladong.二维数组.搜索二维矩阵ii;

public class Solution {

    // 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    // 每行的元素从左到右升序排列。
    // 每列的元素从上到下升序排列。
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角开始 可以保证一个方向遍历完成
        int n = matrix.length, m = matrix[0].length-1;
        int i = 0;
        while (i<n && m>=0) {
            int val = matrix[i][m];
            if (val == target) {
                return true;
            }
            if (val > target) {
                m--;
            } else {
                i++;
            }
        }
        return false;
    }

}
