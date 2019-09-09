/**
 * @author YYDCYY
 * @create 2019-09-08
 */
public class T343 {
    //自顶向下 , 递归实现
    int res[];
    public  int integerBreak(int n) {
        if (n <= 1) return 1;

        if (n <= 4)
            return n;
        res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        res[3] = 2;
        for (int i = 4; i <= n; i ++)
            res[i] = -1;
        return helper(n);
    }

    private int helper(int n){
        if (n == 2) return 2;
        if (n == 3) return 3;
        if (res[n] == -1)
            res[n] = helper(n - 2) >  helper(n - 3) ? res[n-2] *2 : res[n-3]*3;
        return res[n];
    }

    public static void main(String[] args) {
        T343 t = new T343();
        System.out.println(t.integerBreak(10));
    }
}
