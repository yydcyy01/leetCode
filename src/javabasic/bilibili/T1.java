package javabasic.bilibili;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YYDCYY
 * @create 2019-09-10
 */
public class T1 {
}

class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String word1 = in.nextLine();
        String word2 = in.nextLine();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i ++){
            Arrays.fill(dp[i], 0);
        }

        for (int i = 1; i < dp.length; i ++)
            dp[i][0] = i;

        for (int j = 1; j < dp[0].length; j ++)
            dp[0][j] = j;

        for (int i = 1; i < dp.length; i ++){
            for (int j = 1; j < dp[0].length; j ++){
                int temp = dp[i -1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j-1) )
                    temp  += 1;
                    dp[i][j]  = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] +1), temp);
            }
        }

        System.out.println(dp[word1.length()][word2.length()]);
    }
}