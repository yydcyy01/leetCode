import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YYDCYY
 * @create 2019-09-03
 */
public class T120 {
    public static void main(String[] args) {
     /*   int[][] arr = new int[][]{{
     [2]},
    [3,4],
   [6,5,7],
  [4,1,8,3]
]};*/

        Solution120 s = new Solution120();
        List<List<Integer>> list = new ArrayList<>();
        ArrayList a = new ArrayList();
        a.add(2);
       // list.add(Arrays.asList(new int[]{1,2}));
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>()); //5
        System.out.println("size : " + list.size());
    }
}
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;

        int row = triangle.size();//row记录层数, 但有效值为 [0,row-1]
        int[][] dp = new int[row][row];
        for (int level = row-1; level >= 0; level --){
            for (int c = 0; c <= level; c ++){
                dp[level][c] = triangle.get(level).get(c) + Math.min(dp[level][c], dp[level][c+1]);
            }
        }
        return dp[0][0];
    }
}
/**
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 */
//class Solution {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null) return 0;
//
//        int row = triangle.size();
//        Integer[][] dp = new Integer[row+1][row+1];
//        for (int level = level-1; level >= 0; level --){ //level
//            for (int c = 0; c < i-1 && c > 0; c ++){
//                dp[level][c] = dp[level+1][c] + dp[level+1][c+1];
//            }
//        }
//        return dp[0][0];
//    }
//}