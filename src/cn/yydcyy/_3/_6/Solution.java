package cn.yydcyy._3._6;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len /*&& cnt < n*/; i ++){ // cnt < n 是一个优化
            if (flowerbed[i] == 1) continue;
            // 边界判断.
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0){
                flowerbed[i] = 1;
                cnt ++;
            }
        }
        return cnt >=n ;
    }
}