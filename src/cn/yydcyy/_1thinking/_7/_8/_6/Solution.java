package cn.yydcyy._1thinking._7._8._6;

/**
LeetCode 188

 https://blog.csdn.net/azitl/article/details/103761694
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max_k = k;


        int n = prices.length;
        if (k / 2 >= n) {
            // 剪枝, 相当于类型二 : k infinity 次.
            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i ++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }

        // 否则, 穷举.
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i ++) {
            for (k = max_k; k >= 1; k --) { // k有效范围 [0, k]
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