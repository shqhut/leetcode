package com.shq.leetcode.labuladong.二分查找.运送货物;

public class Solution {

    // 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
    // 传送带上的第 i 个包裹的重量为 weights[i]。
    // 每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
    // 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
    public int shipWithinDays(int[] weights, int days) {
        // 类似吃香蕉 自变量为运载能力
        // 运载能力的最小值，一定时weights数组的最大值
        // 运载能力的最大值，一定是weights数组元素的和
        int maxWeight = 0;
        int sumWeight = 0;
        for (int n:weights) {
            maxWeight = Math.max(maxWeight,n);
            sumWeight += n;
        }
        int left = maxWeight,right = sumWeight;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (take(weights, mid) <= days) {
                right = mid;
            } else if (take(weights, mid) > days) {
                left = mid+1;
            }
        }
        return left;
    }

    // 运货公式
    int take(int[] weights, int cover) {
        int res = 1;
        int temp = 0;
        for (int n:weights) {
            if (temp+n <= cover) {
                temp+=n;
            } else {
                res++;
                temp=n;
            }
        }
        return res;
    }

}
