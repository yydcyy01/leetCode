package cn.yydcyy._1thinking._7._2;

/**
 * @author YYDCYY
 * @create 2020-03-12
 * 198. House Robber (Easy)
 * 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 *
 * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
 */
public class House_Robber_Easy {
    /**
         dp[i] = max{dp[i-2] + nums[i], dp[i-1]};
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int p2 = nums[0], p1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i ++) {
            int cur = Math.max(p2 + nums[i], p1);
            p2 = p1;
            p1 = cur;
        }
        return p1;
    }
}
