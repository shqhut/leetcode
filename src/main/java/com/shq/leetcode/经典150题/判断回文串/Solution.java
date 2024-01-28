package com.shq.leetcode.经典150题.判断回文串;

class Solution {
    public boolean isPalindrome(String s) {
        // 移除所有空格,数字
        String s1 = s.replaceAll("\\d","");
        String s2 = s1.replaceAll(" ","");
        int left=0,right=s2.length()-1;
        while(left < right){
            char a = s.charAt(left);
            char b = s.charAt(right);
            if(convert(a) != convert(b)){
                return false;
            }
        }
        return true;
    }

    // 字母字符大写转小写
    char convert(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char)(c+32);
        }
        return c;
    }

    public static void main(String[] args) {

    }


}
