package com.shq.leetcode.labuladong.二分查找.统计目标成绩的出现次数;

public class Solution {

    // 某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。
    // scores = [2, 2, 3, 4, 4, 4, 5, 6, 6, 8], target = 4
    public int countTarget(int[] scores, int target) {
        if (scores.length == 0) {
            return 0;
        }
        // 寻找左边界
        int left = left_bound(scores, target);
        if (left == -1) {
            return 0;
        }
        int right = right_bound(scores, target);
        return right-left+1;
    }

    public int left_bound(int[] scores, int target) {
        int left = 0, right = scores.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (scores[mid] == target) {
                right = mid-1;
            } else if (scores[mid] > target) {
                right = mid-1;
            } else if (scores[mid] < target) {
                left = mid+1;
            }
        }
        if (left >= scores.length || scores[left] != target) {
            return -1;
        }
        return left;
    }

    public int right_bound(int[] scores, int target) {
        int left = 0, right = scores.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (scores[mid] == target) {
                left = mid + 1;
            } else if (scores[mid] > target) {
                right = mid - 1;
            } else if (scores[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || scores[right] != target) {
            return -1;
        }
        return right;
    }

}
