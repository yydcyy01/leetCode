package cn.yydcyy._1thinking._7._7._4;

/**
 * LeetCode 474
 * 不可以初始化 dp[0][0] = 1; 暂时没想明白
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        // dp[0][0] = 1;
        for (String str : strs) {
            // 统计 1 0 个数
            int ones = 0;
            int zeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    ones ++;
                } else if (c == '0') {
                    zeros ++;
                }
            }
            // 从后往前遍历
            for (int i = m; i >= zeros; i -- ) {
                for (int j = n; j >= ones; j --) {
                    //到这, 满足条件, 考虑利益最大化
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"10","0001","111001","1","0"};

        System.out.println(s.findMaxForm(strs, 5, 3));
    }
}