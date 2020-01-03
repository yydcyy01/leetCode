package cn.yydcyy._1._8._1._9._1;

class Solution {


    public static void main(String[] args) {
        int num = 0;
        int subNum = 1;
        for (int i = 0; i < 20; i ++) {

            num += subNum;
            subNum += 2;
            System.out.println(num);
        }
    }
}