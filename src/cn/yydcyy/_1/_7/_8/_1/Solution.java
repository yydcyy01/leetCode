package cn.yydcyy._1._7._8._1;

/**
 * LeetCode 121
 *
 * 状态转移方程见笔记本
 * /**
 *  k == 1情况
 *
 *  因为本题只需要当前dp[i][1] 和前一个状态dp[i-1][1]两个状态, 所以 space() 可以优化为 O(1), dp_i_1, dp_i_0 两个状态表示. 再说.
 *https://blog.csdn.net/azitl/article/details/103761694
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){return 0;}

        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // 解释：
                //   dp[i][0] 
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
                //解释：
                //   dp[i][1] 
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i]) 
                // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
         }
        return dp[n - 1][0];
    }
}