package cn.yydcyy._1thinking._7._8._5;

/**
 * LeetCode 123
对于可以交易 k = 2 次的情况. 
记住穷举哦. (之前 k = 1 / 0 / infinity 次. 所以可以省略, 此处需要 for 穷举.)
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])


链接：
 https://blog.csdn.net/azitl/article/details/103761694
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max_k = 2;

        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i ++) {
            for (int k = max_k; k >= 1; k --) { // k有效范围 [0, k]
                //TODO 
                if (i == 0) {
                    //dp[-1][k][0] = 0;
                    dp[0][k][0] = 0;
                    //dp[-1][k][1] = 0;
                    //dp[0][k][1] = Integer.MIN_VALUE; 
                    dp[0][k][1] = -prices[i]; // 注, 这里不是Integer.MIN_VALUE, 而是 0 - prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}