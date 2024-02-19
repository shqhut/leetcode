package com.shq.leetcode.labuladong.二分查找.爱吃香蕉的珂珂;

public class Solution {

    // 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
    // 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。
    // 每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
    // 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
    // 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
    // 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
    public int minEatingSpeed(int[] piles, int h) {
        // 输入：piles = [3,6,7,11], h = 8
        // 输出：4
        // 找到x的取值范围作为二分搜索的搜索区间
        // 珂珂吃香蕉的最小速度
        int left = 1;
        // 珂珂吃香蕉的最大速度：最大速度是piles数组的最大值，因为每小时最多吃一堆香蕉
        int right = 1000000000;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (eat(piles,mid) == h) {
                right = mid;
            } else if (eat(piles,mid) > h) {
                right = mid;
            } else if (eat(piles,mid) < h) {
                left = mid+1;
            }
        }
        return left;
    }

    // 以k根每小时吃掉全部香蕉的时间
    int eat(int[] piles, int k) {
        int res = 0;
        for (int n:piles) {
            res += n/k;
            int t = n%k;
            if (t != 0) {
                res ++;
            }
        }
        return res;
    }
}
