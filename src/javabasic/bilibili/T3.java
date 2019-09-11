package javabasic.bilibili;

import java.util.Scanner;

/**
 * @author YYDCYY
 * @create 2019-09-10
 */
public class T3 {

}

class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String str = in.nextLine();

        if (str.length() == 0 || str.equals(""))
            return;

        char a = str.charAt(0);
        char b = str.charAt(1);
        String sub = str.substring(2, str.length());

        String[] strArr = sub.split(String.valueOf(a));
        String[][] keyVal =new String[strArr.length][2];

        int sum = 0;
        for (int i = 0; i < strArr.length; i ++){
            keyVal[i] = strArr[i].split(String.valueOf(b));
            if (keyVal[i][0]!= null && !keyVal[i][0].equals("")){
                sum ++;
            }
        }

        System.out.println(sum);
        for (int i = 0; i < strArr.length; i ++){
            if (keyVal[0]!= null && !keyVal[0].equals("")){
                System.out.println(keyVal[i][0] + " "+ keyVal[i][1]);
            }
        }
    }
}
