package com.shq.leetcode.labuladong.滑动窗口.将x减到0的最小操作数;

class Solution {

    // 给你一个整数数组 nums 和一个整数 x 。
    // 每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
    // 请注意，需要 修改 数组以供接下来的操作使用。
    // 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
    public int minOperations(int[] nums, int x) {
        // 思路转换：从nums最左边或最右边移除最少元素，相当于窗口内保留最多元素；
        // 结果应满足，移除元素和为x，相当于留下的元素和为sum(nums)-x；
        // 即当窗口内元素满足和为sum(nums)-x，开始缩小窗口，更新结果
        int maxLen = Integer.MIN_VALUE;
        int n = nums.length;
        // 使用合适的数据结构保存窗口数据
        int sumOfWindows = 0;
        int sumOfNums = 0;
        for (int i:nums) {
            sumOfNums += i;
        }
        int target = sumOfNums - x;
        int left = 0, right = 0;
        while (right < n) {
            // 加入窗口的元素
            int i = nums[right];
            sumOfWindows+=i;
            right++;
            // 缩小窗口
            while (left < right && sumOfWindows > target) {
                // 需要移除的元素
                int j = nums[left];
                // 更新新窗口数据
                sumOfWindows -= j;
                left++;
            }
            if (sumOfWindows == target) {
                maxLen = Math.max(maxLen, right-left);
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,4,2,3};
        int x = 5;
        solution.minOperations(nums,x);
    }

}