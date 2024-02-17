package com.shq.leetcode.经典150题.二分查找.搜索二维矩阵;

class Solution {

    // 给你一个满足下述两条属性的 m x n 整数矩阵：
    // 每行中的整数从左到右按非严格递增顺序排列。
    // 每行的第一个整数大于前一行的最后一个整数。
    // 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
    public boolean searchMatrix(int[][] matrix, int target) {
        // 只需要知道二维数组的行数m和列数n，二维数组的坐标（i,j）可以映射成一维的index = i*n + j
        // 反过来一维的index反解出二维坐标 i = index/n，j = index % n
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i*n + j;
                nums[index] = matrix[i][j];
            }
        }
        // 使用二分查找
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean b = solution.searchMatrix(matrix, target);
        System.out.println(b);
    }

}
