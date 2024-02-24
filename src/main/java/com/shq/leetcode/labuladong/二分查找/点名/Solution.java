package com.shq.leetcode.labuladong.二分查找.点名;

public class Solution {

    // 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
    public int takeAttendance(int[] records) {
        // 利用二分查找，若records[mid]=mid 说明缺失元素在mid右边
        // records[mid]>mid 说明缺失元素在mid左边
        // 不存在records[mid]<mid的情况
        int left = 0, right = records.length-1;
        // [left,right]
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (records[mid] == mid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

}
