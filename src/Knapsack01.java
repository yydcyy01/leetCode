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
        if (c <= 0 || n < 0) return 0;

        // 初始化
        memo = new int[n][c+1];
        // 填充默认值 -1
        for (int i = 0; i < n; i ++)
            Arrays.fill(memo[i], -1);

        return bestValue(w, v, n-1, c);
    }

    //有效范围 : memo[0,index]
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (c <= 0 || index < 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index-1, c); // 当前不要 0+前面一个价值
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index-1, c - w[index]) ); //要当前  v[index] + 前一个价值

        memo[index][c] = res;
        return res;
    }
}
