package cn.yydcyy._3._4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 题意 : (其实是有序的) 身高正序, 名词倒序 , 给打乱了, 让你恢复.
 举个例子 :
 原先 :  [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 排序后    :  7,0 7,1 6,1 5,0 5,2 4,4
 业务处理后 : 5,0 7,0 5,2 6,1 4,4 7,1


 list.add(index, object); // 正常 add()方法是尾插法, 两个参数提供插入为止. 始于 0
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0){
            return new int[0][0];
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
       /* for (int[] p : people){
            System.out.print(" " +p[0] + "," + p[1]);
        }
        System.out.println();*/
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people){
            queue.add(p[1], p);  //list头插法 (index , 对象 )
        }
        return queue.toArray(new int[queue.size()][]);
    }

    /*public static void main(String[] args) {
        Solution s = new Solution() ;
        int [][] t = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        for (int[] p : s.reconstructQueue(t)){
            System.out.print(" " +p[0] + "," + p[1]);
        }
    }*/
}
