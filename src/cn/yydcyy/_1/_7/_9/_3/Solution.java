package cn.yydcyy._1._7._9._3;

/**
 * LeetCode 650
 * @author YYDCYY
 * @create 2019-12-31
 */
public class Solution {
    public int minSteps(int n) {
        int[] dp = new int [n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i ++) {
            dp[i] = i;
            for (int j = 2; j <= h; j ++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;  // 找到一个即可
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSteps(30));
    }
}