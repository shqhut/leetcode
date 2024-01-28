package com.shq.leetcode.经典150题.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        // [-1,0,1,2,-1,-4] 三数之和为0
        // 穷举，以第一个元素开始，和另外两个数和为0
        // 相当于求数组除第一个元素之外，两个数和为target=0-nums[i]
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            List<List<Integer>> list = towSum(nums, i + 1, 0 - x);
            if (list.size() == 0) {
                continue;
            }
            for (List<Integer> item : list) {
                item.add(nums[i]);
                ans.add(item);
            }
            while (i+1<nums.length && nums[i+1] == x) {
                i++;
            }
        }
        return ans;
    }

    List<List<Integer>> towSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 双指针
        int left = start, right = nums.length-1;
        while (left < right) {
            int x = nums[left];
            int y = nums[right];
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
                while (left < right && nums[right] == y) {
                    right--;
                }
            } else if (sum < target) {
                left++;
                while (left < right && nums[left] == x) {
                    left++;
                }
            } else {
                List<Integer> part = new ArrayList<>();
                part.add(x);
                part.add(y);
                result.add(part);
                left++;
                right--;
                while (left < right && nums[left] == x) {
                    left++;
                }
                while (left < right && nums[right] == y) {
                    right--;
                }
            }
        }
        return result;
    }

}
