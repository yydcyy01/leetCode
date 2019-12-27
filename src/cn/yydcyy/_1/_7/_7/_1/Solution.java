package cn.yydcyy._1._7._7._1;

/**
 * 2019年12月27日08:48:23
 *
 * LeetCode 416  :
 *
 * 方法 1 拆分成 sum / 2 为 0-1 背包问题
 *
 * 方法 2 : "组非空，且长度不会超过20。" :  2^20 = 1024 * 1024 才 100W, 1000W 次计算 1 秒内可搞定. 所以 ok.
 *  可以用 dfs 计算.
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

/**
 组非空，且长度不会超过20。 2^20 = 1024 * 1024 才 100W, 1000W 次计算 1 秒内可搞定. 所以 ok.
 可以用 dfs 计算.
 */
/*
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }
    private int findTargetSumWays(int[] nums,int start, int S) {
        if (start == nums.length)
            return S == 0? 1 : 0;

        return findTargetSumWays(nums, start + 1, S + nums[start]) + findTargetSumWays(nums, start + 1, S - nums[start]);
    }

}*/
