package cn.yydcyy._1._7._5._3;

/**
 LeetCode 376
 Time O (n)
 Space O (1)
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if ( nums == null|| nums.length == 0){
            return 0;
        }

        int up = 1, down = 1;
        for (int i = 1; i < nums.length ; i ++){
            //相等不处理.
            if (nums[i] == nums[i - 1])
                continue;

            // up, up, ....  down 是没变的, 故结果只会+1.
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else
                down = up + 1;
        }
        return Math.max(up, down);
    }
}