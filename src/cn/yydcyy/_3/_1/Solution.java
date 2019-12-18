package cn.yydcyy._3._1;

import java.util.Arrays;

/**
 * _3.1
 *  LeetCode 455
 */
class Solution {
    /**
     贪心思想 : 用最小资源满足最多孩子数. 故需要先排序, 直接往后判断即可.
     */
    public int findContentChildren(int[] g, int[] s) {
        // 排序, 贪心思想
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length){ // 终止条件 : gi 孩子下标没了 或 si 饼干下标没了.
            if (g[gi] <= s[si]){  // 比较 g[gi] 和 s[si]
                gi ++; //满足则孩子下标 ++
            }
            si ++;   // 不满足, 则饼干下标++ , 注 : 表明 "饼干太小, 扔了"或"饼干被使用了."
        }
        return gi; // 返回排序后最大满足的孩子下标, 即最优解
    }
}