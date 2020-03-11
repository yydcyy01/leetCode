package cn.yydcyy._1thinking._8._1._7._1;

import java.util.Arrays;

/**
 * LC 462
 先排序, 复杂度 : O (n log n )
 相遇问题, 每次最多 ++ -- , 问移动多少次可以把所以元素变成全相同.
 nums[R] - nums[L] = (nums[R] - N) + (N - nums[L] );
*/
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int L = 0; //左边界
        int R = nums.length - 1; // 右边界
        int res = 0;
        while (L <= R) {
            res += nums[R] - nums[L];
            L ++;
            R --;
        } 
        return res;
    }
}