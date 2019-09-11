package com.yydcyy.group3;

/**
 * @author YYDCYY
 * @create 2019-09-12
 * 注意 : 生成 RandomArray 数组中, (Math.random() * (rangeR - rangeL + 1)) + rangeL;   加一这个边界条件细节, 好好体会下
 */
public class Util {
    //内部工具类, 生成有序数组
    public static Integer[] generateOrderedArray(int n) {
        assert n > 0 ;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i ++){
            arr[i] = i;
        }
        return arr;
    }

    //内部工具类, 生成随机数组数组
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i ++){
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL; //范围内,
        }
        return arr;
    }
}
