package javabasic.bilibili;

import java.util.Scanner;

/**
 * @author YYDCYY
 * @create 2019-09-10
 */
public class T2 {

}


// 通过 80% 样例
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int res = 0;
        for (int i = 1,j = 1; i <= j && j <= n; ){
            int sum = (i + j)*(j-i + 1) / 2;
            if (sum < n){
                j ++;
            }
            else if (sum == n) {
                res ++;
                i ++;
            }
            else { // sum > n
                j --;
                i ++;
            }
        }
        System.out.println(res + 1);
    }
}