package cn.yydcyy._1._1._4;

/**
LeetCode 680. 验证回文字符串 Ⅱ
*/
class Solution {
    public boolean validPalindrome(String s) {
        // 题目说了"给定一个非空字符串 s", 不需要边界处理了.
        for (int i = 0, j = s.length() - 1; i <= j; i ++, j -- ) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int i, int j) {
        for (; i <= j; i ++, j --) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}