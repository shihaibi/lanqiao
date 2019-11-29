package 递归和深度优先搜索;

import java.util.Arrays;

public class 机器人走方格 {
    public static void main(String[] args) {
        System.out.println(solve(5,5));
        System.out.println(solve1(5,5));
        System.out.println(solve2(5,5));
    }
    public static int solve(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        return solve(x - 1, y) + solve(x, y - 1);
    }
    public static int solve1(int x, int y) {
        int[] dp = new int[y];
        Arrays.fill(dp, 1);
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[y - 1];
    }
    public static int solve2(int x, int y) {
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < y; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i != 0 && j != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[x - 1][y - 1];
    }
}
