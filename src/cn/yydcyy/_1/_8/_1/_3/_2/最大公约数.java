package cn.yydcyy._1._8._1._3._2;

/**
 * @author YYDCYY
 * @create 2019-12-31
 */
public class 最大公约数 {
    public static int gcb(int a, int b){
        return b == 0 ? a : gcb(b, a % b);
    }
}
