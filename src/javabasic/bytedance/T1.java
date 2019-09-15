package javabasic.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YYDCYY
 * @create 2019-09-15
 */
public class T1 {

}

// 本题为考试多行输入输出规范示例，无需提交，不计分。

 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int [n];
        for (int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int res = 0;


        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i ++){
            for (int j = i + 1,m = j+1; j < n - 1 && m < n && m > j; ){
                if (arr[i] + arr[j] + arr[m] < k){
                    res ++;
                    m ++;
                }
                else {
                    j ++;
                    m = j+1;
                }
            }
        }
        System.out.println(res);
    }
}
/*
7
1 2 6 -2 0 3 6
2
 */