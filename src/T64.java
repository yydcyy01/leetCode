/**
 * @author YYDCYY
 * @create 2019-09-07
 */
public class T64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = 0, n = 0;
            for (; m < grid.length; m ++){
                for (; n < grid.length; n ++){
                    int L = m >= 1 ? grid[m-1][n] : 0;
                    int R = n >= 1 ? grid[m][n-1] : 0;
                    grid[m][n] += Math.min(L, R);
                }
            }
            return grid[m-1][n-1];
        }
    }
}
