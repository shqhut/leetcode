package com.shq.leetcode.每日一题.拿出最少数目的魔法豆;

import com.alibaba.fastjson2.JSON;

import java.io.*;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long minimumRemoval(int[] beans) {
        // 先对beans进行排序
        Arrays.sort(beans);
        // [4,1,6,5]
        long[] beansSum = new long[beans.length];
        for (int i = 0; i < beans.length; i++) {
            if (i-1 == -1) {
                beansSum[i] = beans[i];
                continue;
            }
            beansSum[i] = beansSum[i-1] + beans[i];
        }
        long result = Integer.MAX_VALUE;
        for (int i = 0; i < beans.length; i++) {
            // 将beans[0,...,i-1]的袋子中的元素全部清0
            // beans[i+1,beans.lenght-1]的元素全部设置成beans[i]
            // beans[i+1,beans.lenght-1]的元素和
            long x = beansSum[beansSum.length-1] - beansSum[i];
            // beans[i+1,beans.lenght-1]剩余的元素和
            long y = beans[i] * (beans.length-1-i);
            // 总共拿出的豆子数量，如果i=0时，i-1会越界，需特殊处理
            long count;
            if (i == 0) {
                count = x - y;
            } else {
                count = beansSum[i-1] + x - y;
            }
            result = Math.min(result,count);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(new File("/Users/wayz/leetcode/src/main/resources/static/arr.json"));
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = new char[1024];
        int readLine = 0;
        while ((readLine = reader.read(chars)) != -1) {
            stringBuilder.append(new String(chars,0,readLine));
        }
        reader.close();
        List<Integer> integers = JSON.parseArray(stringBuilder.toString(), Integer.class);
        int[] beans = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            beans[i] = integers.get(i);
        }
        Solution solution = new Solution();
        solution.minimumRemoval(beans);
    }
}
