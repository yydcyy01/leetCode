package cn.yydcyy._1._7._7._1;

/**
 * 2019年12月27日08:48:23
 * LeetCode 416  : 拆分成 sum / 2 为 0-1 背包问题
 */

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return true;
        }

        int sum = Sum(nums);
        if (sum % 2 != 0)
            return false;

        int w = sum / 2;
        boolean[] dp = new boolean[w + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = w; i >= num; i --) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[w];

    }
    private int Sum(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}