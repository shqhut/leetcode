package com.shq.leetcode.labuladong.二维数组.重塑矩阵;

public class Solution {

    // 在 MATLAB 中，有一个非常有用的函数 reshape ，
    // 它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
    // 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
    // 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
    // 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // 先将mat转换为一维数组
        int m = mat.length;
        int n = mat[0].length;
        if (m*n != r*c) {
            return mat;
        }
        int[] nums = new int[m*n];
        for (int i = 0; i < m * n; i++) {
            int x = i/m;
            int y = i%n;
            nums[i] = mat[x][y];
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            int x = i/r;
            int y = i%c;
            res[x][y] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[2][2];
    }

}
