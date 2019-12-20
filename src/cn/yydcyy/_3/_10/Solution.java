package cn.yydcyy._3._10;

/**
 * 53最大子序和
 *
 *这个写法优化过 : 初始化 preSum = nums[0];maxSum = preSum; for 循环从 1 开始.   解决了  [0]  [-1]等只有一个数的测试用例.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        int preSum = nums[0]; // 记录当前最大值
        int maxSum = preSum; // 记录历史最大值
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i]; // 累计大于 0?是则加上之前的值.  否则只去前值.
            maxSum = Math.max(preSum, maxSum); //  更新最大值 : 历史最大值或当前最大值.
        }
        return  maxSum;
    }
}