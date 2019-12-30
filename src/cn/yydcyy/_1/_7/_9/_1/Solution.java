package cn.yydcyy._1._7._9._1;

/**
1.7.9 字符串编辑类型
LC 72
套用最长公共子序列做, dp[][] 存的是最小编辑次数
状态方程 : 
    dp[i][j] = dp[i - 1][j - 1];  //word1.charAt(i - 1) == word2.charAt(j - 1) 
    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;  //word1.charAt(i - 1) != word2.charAt(j - 1)
                
*/
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length(); 
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; i ++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j ++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}