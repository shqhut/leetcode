package com.shq.leetcode.每日一题.拿出最少数目的魔法豆;

import com.alibaba.fastjson2.JSON;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public long minimumRemoval(int[] beans) {
        long result = Long.MAX_VALUE;
        long sum = 0;
        Arrays.sort(beans);
        for (int i:beans) {
            sum+=i;
        }
        for (int i = 0; i < beans.length; i++) {
            long total = sum - ((long) beans[i] * (beans.length - i + 1));
            result = Math.min(result,total);
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
        Solution2 solution = new Solution2();
        solution.minimumRemoval(beans);
    }

}
