package com.shq.leetcode.经典150题.矩阵.矩阵归零;

public class Solution {

    // 给定一个 m x n 的矩阵，如果一个元素为 0 ，
    // 则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
    public void setZeroes(int[][] matrix) {
        // 使用两个数组标记元素为0所在行和列为ture
        // 再次遍历矩阵时，将行、列元素都置0
        int m = matrix[0].length;
        int n = matrix.length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = true;
                    column[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[j] || column[i] ) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
