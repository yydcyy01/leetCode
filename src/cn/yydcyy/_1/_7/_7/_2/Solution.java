package cn.yydcyy._1._7._7._2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {   // 对物品的迭代应该放在最里层
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList list = new ArrayList<String>();
        list.add("leet");
        list.add("code");
        System.out.println(s.wordBreak("leetcode",list));
    }
}