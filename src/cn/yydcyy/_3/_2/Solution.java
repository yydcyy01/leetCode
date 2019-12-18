package cn.yydcyy._3._2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2019年12月18日
 * LC 435 , 要求最少删除数 : 总数 - 合理数 = 最少删除数
 * 二次做题时候补解题思路
 *
 * 这个方法好用 !  注 : 可以填 int[], 它为非基本类型.
 * Arrays.sort(intervals,new Comparator<int []>(){
 *
 *             @Override
 *             public int compare(int[] o1, int[] o2) {
 *                 // <0 则左边小 : =0 则= : >0 则左边大
 *                 return o1[1] - o2[1];
 *             }
 *         });
 *Arrays.sort()方法,直接排序,不用for_each遍历,但是二维数组不可以直接调用Arrays.sort()方法,只有一维数组可以
 * 参考资料 :
 * https://blog.csdn.net/chao_ji_cai/article/details/100072293
 * https://zhidao.baidu.com/question/584126645687159005.html
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 ) return 0;

        Arrays.sort(intervals,new Comparator<int []>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                // <0 则左边小 : =0 则= : >0 则左边大
                return o1[1] - o2[1];
            }
        });
        /*
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        使用 lambda 表达式创建 Comparator 会导致算法运行时间过长, 可改为普通类
        */
        int cnt = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end){
                continue;
            }

            end = intervals[i][1]; //intervals[i] , 不是 intervals[cnt] 哦, 按照 i 索引
            cnt ++;

        }
        return intervals.length - cnt; // 总数 - 合理数 = 最少删除数
    }
}