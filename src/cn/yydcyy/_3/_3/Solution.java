package cn.yydcyy._3._3;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 ) return 0;

        Arrays.sort(points,new Comparator<int[]>(){

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
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end){
                continue;
            }

            end = points[i][1]; //intervals[i] , 不是 intervals[cnt] 哦, 按照 i 索引
            cnt ++;

        }
        return cnt; // 总数 - 合理数 = 最少删除数
    }
}