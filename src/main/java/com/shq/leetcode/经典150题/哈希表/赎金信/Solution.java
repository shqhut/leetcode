package com.shq.leetcode.经典150题.哈希表.赎金信;

class Solution {

    //  给你两个字符串：ransomNote和magazine，判断 ransomNote 能不能由 magazine 里面的字符构成。
    //  如果可以，返回true；否则返回false。
    //  magazine 中的每个字符只能在 ransomNote 中使用一次。
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countRansomNote = encode(ransomNote);
        int[] countMagazine = encode(magazine);
        for (int i = 0; i < countRansomNote.length; i++) {
            if (countRansomNote[i] > countMagazine[i]) {
                return false;
            }
        }
        return true;
    }

    int[] encode(String str) {
        int[] count = new int[26];
        for (char a:str.toCharArray()) {
            int i = a - 'a';
            count[i]++;
        }
        return count;
    }



}
