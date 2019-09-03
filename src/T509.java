/**
 * @author YYDCYY
 * @create 2019-09-03
 */
public class T509 {
    /*
        Space O(n) / O(1) dp
        time  O(n)
     */
    public static void main(String[] args) {
        /*Solution s = new Solution();
        System.out.println(s.fib(10000)); // N 太大 结果可能溢出
        // System.out.println("time : " + s.time); //记录运行次数*/

    }
}

/**
 * 记忆化搜索, 自顶向下
 */
class Solution509 {
    //int time;
    int[] res;
    public int fib(int N) {
        res = new int[N + 1];

        if (N < 0)
            return 0;
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;

        res[0] = 0;
        res[1] = 1;
         for (int i = 2; i <= N; i ++)
             res[i] = -1;

        return helper(N);
    }
    private int helper(int n){
        //time ++;
        if (res[n] == -1)
            res[n] = helper(n - 1) + helper(n - 2);

        return res[n];
    }
}

// dp 解决 : 自下而上
class Solution5092 {
    int[] res;
    public int fib(int N) {
        if (N <= 0) return 0;
        if (N == 1) return 1;

        res = new int[N + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= N; i ++){
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[N];
    }
}