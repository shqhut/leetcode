package com.shq.leetcode.经典150题.矩阵.旋转图像;

public class Solution {

    public void rotate(int[][] matrix) {

        // 旋转矩阵 转换思维：先将矩阵沿（0,0）-> (n,n)对角线反转，在将矩阵对称反转 相当于顺时针旋转90度
        for (int i = 0; i < matrix.length; i++) {
            // 理解的关键点，交换两个位置的元素，避免遍历每个元素，只需要遍历没有参与过的元素
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            // 将一维数组轴对称
            rollback(matrix[i]);
        }
    }

    void rollback(int[] arr) {
        int i = 0, j = arr.length-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
