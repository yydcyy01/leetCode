package cn.yydcyy._1._7._8._2;
/**
 * LeetCode 122
 第二题，k = +infinity

 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：

 dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])

 我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
 dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-w-5/
 https://blog.csdn.net/azitl/article/details/103761694
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}