package com.shq.leetcode.经典150题.矩阵.螺旋矩阵;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        // 顺时针遍历矩形的四条边
        // 1、左上->右上，缩小上边界；
        // 2、右上->右下，缩小右边界；
        // 3、右下->左下，缩小下边界；
        // 4、左下->左上，缩小左边界；
        int m = matrix[0].length;
        int n = matrix.length;
        int up_bound = 0, low_bound = m-1;
        int left_bound = 0, right_bound = n-1;
        while (res.size() < m*n) {
            if (up_bound <= low_bound) {
                for (int i = left_bound; i <= right_bound; i++) {
                    int temp = matrix[up_bound][i];
                    res.add(temp);
                }
                up_bound++;
            }
            if (left_bound <= right_bound) {
                for (int i = up_bound; i <= low_bound; i++) {
                    int temp = matrix[i][right_bound];
                    res.add(temp);
                }
                right_bound--;
            }
            if (up_bound <= low_bound) {
                for (int i = right_bound; i >= left_bound; i--) {
                    int temp = matrix[low_bound][i];
                    res.add(temp);
                }
                low_bound--;
            }
            if (left_bound <= right_bound) {
                for (int i = low_bound; i >= up_bound; i--) {
                    int temp = matrix[i][left_bound];
                    res.add(temp);
                }
                left_bound++;
            }
        }
        return res;
    }

}
