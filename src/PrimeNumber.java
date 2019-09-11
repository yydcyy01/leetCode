/**
 * @author YYDCYY
 * @create 2019-09-10
 */
public class PrimeNumber {
    /**
     * time : O (sqrt(n))
     * @param
     * @return
     */

    public static void main(String[] args) {
       // System.in sc = System.in();
    }
    public boolean isPrimeNumber(int n) {
        for (int x = 2; x * x < n; x++){
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }
}
