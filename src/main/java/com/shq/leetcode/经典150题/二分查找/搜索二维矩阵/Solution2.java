package com.shq.leetcode.经典150题.二分查找.搜索二维矩阵;

public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        while (left < right) {
            int mid = (left + right) / 2;
            int numOfMid = getValue(mid, matrix, m, n);
            if (numOfMid == target) {
                return true;
            } else if (numOfMid > target) {
                right = numOfMid;
            } else if (numOfMid < target) {
                left = numOfMid;
            }
        }
        return false;
    }

    int getValue(int index, int[][] matrix, int m, int n) {
        int i = index/n;
        int j = index%m;
        return matrix[i][j];
    }


}
