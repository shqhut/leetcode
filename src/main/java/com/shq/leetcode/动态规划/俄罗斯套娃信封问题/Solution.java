package com.shq.leetcode.动态规划.俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        int ans = 1;
        int n = envelopes.length;
        // 将envelopes二维数组，根据宽排序，最多能有多少个信封能组成“俄罗斯套娃”就相当于长度的连续递增子序列长度的问题了
        // 按宽度升序，如果宽度一样，按高度降序
//        for (int i = envelopes.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (envelopes[j][0] > envelopes[j + 1][0]
//                        || (envelopes[j][0] == envelopes[j + 1][0] && envelopes[j][1] < envelopes[j + 1][1])) {
//                    int temp1 = envelopes[j][0];
//                    int temp2 = envelopes[j][1];
//                    envelopes[j][0] = envelopes[j + 1][0];
//                    envelopes[j][1] = envelopes[j + 1][1];
//                    envelopes[j + 1][0] = temp1;
//                    envelopes[j + 1][1] = temp2;
//                }
//            }
//        }
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
//            }
//        });
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
//        int[] dp = new int[envelopes.length];
//        for (int i = 0; i < envelopes.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (envelopes[i][1] > envelopes[j][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        for (int i : dp) {
//            ans = Math.max(i, ans);
//        }
        int[] height = new int[n];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i : dp) {
            ans = Math.max(i, ans);
        }
        return ans;
    }



}
