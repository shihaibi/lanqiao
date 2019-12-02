package 贪心策略与动态规划;

import java.util.Scanner;

public class 字典序最小问题 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        char[] arr = new char[num];
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextLine().charAt(0);
        }
        String a = String.valueOf(arr);
        get(a);
    }

    public static void get(String a) {
        int start = 0;
        int len = a.length() - 1;
        int count = 0;
        while (start <= len) {
            int start1 = start;
            int len1 = len;
            while (start1 < len1 && a.charAt(start1) == a.charAt(len1)) {
                start1++;
                len1--;
            }
            if (a.charAt(start1) <= a.charAt(len1)) {
                System.out.print(a.charAt(start++));
            } else {
                System.out.print(a.charAt(len--));
            }

            count++;
            if (count%80 == 0) {
                System.out.println();
            }
        }

    }
}
