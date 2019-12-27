package cn.yydcyy._1._7._7._3;

import java.util.List;
/**
 * 2019年12月27日10:12:46
 LC 139. 单词拆分 [ 完全背包问题 ]

 dict 中单词没有使用上限, 因此是一个完全背包问题.
 完全背包和 0-1 背包在实现上不同 : 0-1 背包对物品迭代在外层, 完全背包对物品迭代在内层.

 ------------
 s.substring(i - n, i) // 不是 sub
 string.eauals(string);
 用好 短路与&&, 很方便的.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i ++) {
            for (String word : wordDict) { // 完全背包, 对物品迭代放内层
                int n = word.length(); // 当前单词长度.
                if (n <= i && word.equals(s.substring(i - n, i))) {
                    dp[i] = dp[i] || dp[i - n];
                }
            }
        }
        return dp[len];
    }
}