package com.shq.leetcode.经典150题.整数转罗马数字;

public class Solution {

    public String intToRoman(int num) {
        String res = "";
        if (num == 4) {
            return "IV";
        } else if (num == 9) {
            return "IX";
        } else if (num == 40) {
            return "XL";
        } else if (num == 100) {
            return "XC";
        } else if (num == 400) {
            return "CD";
        } else if (num == 900) {
            return "CM";
        }
        
        return res;
    }

}
