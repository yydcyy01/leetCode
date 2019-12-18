package cn.yydcyy._3._8;

class Solution {
    /*
    LC 665
    2019年12月18日19:30:53
    解题思路 2
        nums[i] < nums[i - 1] 为异常情况, 需要替换且最多替换 1 次.

        (此题特殊位置, 记住吧.)
        优先考虑 nums[i - 1] = nums[i] : 替换前一个.  减少对后续影响
        但是 一种情况考虑 : 索引 i - 2 >= 0 时, 若 nums[i - 2] > nums[i] 为了不影响 nums[i]前的"不降序"结果, 需要nums[i] > nums[i - 1] 替换.

     */
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; cnt < 2 &&  i < nums.length; i ++){
            // 满足条件情况
            if (nums[i - 1] < nums[i]){
                continue;
            }
            // 不满足, 处理
            cnt ++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]){
                nums[i] = nums[i - 1];
            }else {
                nums[i - 1] = nums[i];
            }
        }
        // 这个判断方法简洁优秀.
        return cnt <= 1;
    }
}



// 解题思路1 :  直接返回true/ false 呗, 改啥?   测试用例死在了 [3 4 2 3] , 自己太天真了.
class Solution2 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 2 || nums == null ){
            // length == 0 | 1
            return true;
        }
        // length >= 2
        int cnt = 0;
        int i ;
        for (i = 1; cnt < 2 &&  i < nums.length; i ++){
            if (nums[i - 1] > nums[i]){
                cnt ++;
            }
        }
        if (i == nums.length && cnt < 2){
            return true;
        }
        return false;
    }
}