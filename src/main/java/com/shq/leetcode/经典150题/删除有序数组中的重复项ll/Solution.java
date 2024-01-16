package com.shq.leetcode.经典150题.删除有序数组中的重复项ll;

public class Solution {

    /**
     * 给你一个有序数组nums，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，
     * 返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用O(1)额外空间的条件下完成。
     *
     * 疑问：时间复杂度O(1)？指向次数固定；
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 双指针技巧，nums[...slow]表示有效元素
        int slow = 0, fast = 0;
        // 记录重复次数
        int count = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                // fast为新加入元素
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                // slow<fast的判断条件是为了处理刚开始几个元素都是相等的case：[1,1,1,2,2,3]
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast-1]) {
                // 新的元素进来了
                count = 0;
            }
        }
        return slow+1;
    }

}
