package cn.yydcyy._1thinking._8._1._3._2;

/**
 * @author YYDCYY
 * @create 2019-12-31
 */
public class 最小公倍数 {
    public int lcm(int a, int b){

        return a * b / (最大公约数.gcb(a, b));
    }
}
