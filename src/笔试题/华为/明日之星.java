package 笔试题.华为;

import java.util.Arrays;
import java.util.Scanner;


public class 明日之星 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean sign = false;
        if (str.length() == 0) {
            System.out.println("error.0001");
            sign = true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) && str.charAt(i) != ',') {
                System.out.println("error.0001");
                sign = true;
                break;
            }
        }
        if (!sign) {
            String[] strs = str.split(",");
            for (int i = 0; i < strs.length; i++) {
                if (!Character.isUpperCase(strs[i].charAt(0))) {
                    System.out.println("error.0001");
                    System.exit(0);
                }
                for (int j = 1; j < strs[i].length(); j++) {
                    if (!Character.isLowerCase(strs[i].charAt(0))) {
                        System.out.println("error.0001");
                        System.exit(0);
                    }
                }
            }
            Arrays.sort(strs);
            int maxNum = 1;
            String maxName = strs[0];
            int curNum = 1;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].equals(strs[i - 1])) {
                    curNum++;
                    if (maxNum < curNum) {
                        maxNum = curNum;
                        maxName = strs[i];
                    }
                } else {
                    curNum = 1;
                }
            }
            System.out.println(maxName);
        }
    }
}
