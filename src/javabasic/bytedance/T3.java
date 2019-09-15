package javabasic.bytedance;

import java.util.Scanner;

/**
 * @author YYDCYY
 * @create 2019-09-15
 */
public class T3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 101; i ++){ //101 个数
            System.out.print(" "+i);
        }
    }
}
class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long result = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }

        int L = 0;
        int R = n-1; //有效范围

        int count = 1;
        while (L <= R){

            result += arr[L] > arr[R] ? arr[L ++] : arr[R --];

            if (L <= R){
                if (arr[L] > arr[R])
                    L ++;
                else
                    R --;
            }

        }
        System.out.println(result);
    }
}