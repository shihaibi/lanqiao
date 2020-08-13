package 笔试题.美团;

import java.util.Scanner;

public class 字符串模式匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        String t = sc.nextLine();
        boolean[][] dp = new boolean[p.length() + 1][t.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(i - 1) == '?' || p.charAt(i -1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                }
            }
        }
        if (dp[p.length()][t.length()]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
