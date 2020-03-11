package cn.yydcyy._1thinking._7._5._1;

/**
 *LeetCode 300
 * ------------
 *
 * 骚操作. 1.8 引入的 stream 高级版 Iteratior
 * Arrays.stream(dp).max().orElse(0)
 * 自己写的 binarySearch 模板 : 可以改成① 返回可用的最小索引. ② 是否存在 , true / false
 */

/**
 * 优化 2 , 维护一个最长子序列的数组.
 * Time : O( n logn)
 * space : O (n)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] tails =new int[nums.length];
        int len = 0;
        for (int i = 0 ; i < nums.length; i ++ ){
            int index = binarySearch(tails, len, nums[i]); // 查找的数组是 tails, 不是 nums哦
            tails[index] = nums[i];
            if (index == len)
                len ++;
        }
        return len;
    }

    private int binarySearch(int[] tails,int len,int key){
        int L = 0, H = len;
        while (L < H){
            int mid = L + (H - L) / 2;
            if (tails[mid] == key)
                return mid;  // 终结
            else if (tails[mid] > key)
                H = mid;
            else
                L = mid + 1;
        }
        return L; // 无, 返回最左索引, 本题为 0.
    }
}




/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n]; // 有效范围 [0, n)
        //dp[0] = 1;
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = Math.max(max, dp[i]);
        }
        int max = dp[0];
        for (int i = 0; i < n; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}*/