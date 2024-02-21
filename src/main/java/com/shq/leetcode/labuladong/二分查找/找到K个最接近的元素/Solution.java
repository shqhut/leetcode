package com.shq.leetcode.labuladong.二分查找.找到K个最接近的元素;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 先用二分查找，找到x值的左边界；
        // 再用双指针添加元素
        int p = left_bound(arr, x);
        LinkedList<Integer> res = new LinkedList<>();
        // 搜索区间（left,right）
        int left = p-1, right = p;
        // 循环条件，保证（left,right）中有k个元素
        while (right - left - 1 < k) {
            // 当left到达边界，就只有右边元素符合
            if (left == -1) {
                res.addLast(arr[right]);
                right++;
            } else if (right == arr.length) {
                res.addFirst(arr[left]);
                left--;
            } else if (x - arr[left] > arr[right] - x) {
                res.addLast(arr[right]);
                right++;
            } else {
                res.addFirst(arr[left]);
                left--;
            }
        }
        return res;
    }

    public int left_bound(int[] arr, int x) {
        int left=0, right=arr.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (arr[mid] == x) {
                right = mid;
            } else if (arr[mid] > x) {
                right = mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;
        Solution solution = new Solution();
        List<Integer> closestElements = solution.findClosestElements(arr, k, x);
        System.out.println(closestElements);
    }

}
