import java.util.Arrays;

/**
 * @author YYDCYY
 * @create 2019-09-09
 */
public class Knapsack01 {

    int[][] memo;

    //背包[0, .... ,index-1]  C : 背包大小, [i]w :i 背包的价值    [i]v : i 背包的价值
    public int knapsack01(int[] w, int[] v, int c) {

        int n = w.length;
        if (c < 0 || n < 0) return 0;

        // 填充默认值 -1
        for (int i = 0; i < n; i ++){
            Arrays.fill(memo[i], -1);
        }
        memo = new int[n][c+1];

    }
}
