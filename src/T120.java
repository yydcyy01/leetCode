import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YYDCYY
 * @create 2019-09-03
 */
public class T120 {
    public static void main(String[] args) {
        Integer [][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        Solution120 s = new Solution120();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a1 = Arrays.asList(arr[0]);
        List<Integer> a2 = Arrays.asList(arr[1]);
        List<Integer> a3 = Arrays.asList(arr[2]);
        //List<Integer> a4 = (ArrayList) Arrays.asList(arr[3]); //强制转换报错
        List<Integer> a4 = Arrays.asList(arr[3]);

       // list.add(Arrays.asList(new int[]{1,2}));
        list.add(a1);
        list.add(a2);
        list.add(a3); //5
        list.add(a4); //5
        System.out.println(s.minimumTotal(list));
    }
}
class Solution120 {
    /*public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;

        int row = triangle.size();//row记录层数, 但有效值为 [0,row-1]
        int[][] dp = new int[row][row];
        //初始化最后一行
        for (int c = 0,level = row-1; c <= level; c ++){
            dp[level][c] = triangle.get(level).get(c);
        }

        //倒数第二行, dp 自底向上记忆化处理
        for (int level = row-1-1; level >= 0; level --){
            for (int c = 0; c <= level; c ++){ //这里应该至 level - 1;  因下面有个比较. 不-1 越界
                dp[level][c] = triangle.get(level).get(c) + Math.min(dp[level + 1][c], dp[level + 1][c+1]);
            }
        }
        return dp[0][0];
    }*/
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;

        int row = triangle.size();//row记录层数, 但有效值为 [0,row-1]
        int[]dp = new int[row];
        //初始化
        for (int c = 0; c <= row - 1; c ++){
            dp[c] = triangle.get(row-1).get(c);
        }

        //倒数第二行, dp 自底向上记忆化处理
        for (int level = row-1-1; level >= 0; level --){
            for (int c = 0; c <= level; c ++){ //这里应该至 level - 1;  因下面有个比较. 不-1 越界
                dp[c] = triangle.get(level).get(c) + Math.min(dp[c],dp[c+1]);
            }
        }
        return dp[0];
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
