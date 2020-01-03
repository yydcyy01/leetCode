package cn.yydcyy._1._8._1._8._1;

/**
 * LC 169 [ 投票问题 ] 统计 n/2 问题.
 */
class Solution {
    public int majorityElement(int [] nums){
       int count = 0; // 记录投票结果
        int res = 0; //
        for (int num : nums) {
            // 先更新最大值.
            if (count == 0) {
                res = num;
            }
            // 统计最大票数.
            if (num != res) {
                count--;
            } else { 
                count++;
            }
        }
        return res;
    }
}