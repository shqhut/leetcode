package com.shq.leetcode.经典150题.反转字符串中的单词;

class Solution2 {

    public String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    //使用StringBuild来完成去除空格的操作
    //相向行驶的双指针完成除去空格的操作
    public static StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length()-1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {     //这一步是最关键的一步，不仅录入了单词之间的空格，而且还只录了一个空格。高！！！
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    //使用相向的双指针完成反转
    //使用StringBuild+双指针完成整个字符串的反转
    public static void reverseString(StringBuilder sb, int start,int end){
        while (start < end) {
            char temp = sb.charAt(start);   //创建一个临时的字符，用来保存，完成字符串的反转
            sb.setCharAt(start, sb.charAt(end));  //StringBuilder的setCharAt（参数1，参数2） ：把参数1位置的字符更改为参数2
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    //完成单个单词的反转
    //使用同向行驶的双指针来完成单词的反转，主要思路是在反转字符串的基础上加上了空格的判断
    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') { //将end指针停留在空格的位置
                end++;
            }

            reverseString(sb, start, end - 1);   //将单词反转
            start = end + 1;  //再次开始下一个单词的反转，高！！！
            end = start + 1;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.reverseWords("a good   example");
    }
}

