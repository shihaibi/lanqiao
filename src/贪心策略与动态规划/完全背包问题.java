package 贪心策略与动态规划;

public class 完全背包问题 {
    static int[] w = {2,1,3,2};
    static int[] v = {3,2,4,2};
    static int W = 10;
    static int[][] dp;

    public static void main(String[] args) {
        System.out.println(get1());
    }

    private static int get1() {
        dp = new int[w.length][W + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0) {
                    if (j >= w[0])
                        dp[i][j] = v[i] + dp[0][j - w[0]];
                    else
                        dp[i][j] = 0;
                    continue;
                }
                if (j >= w[i])
                    dp[i][j] = Math.max(dp[i - 1][j], v[i] + dp[i][j - w[i]]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[w.length - 1][W];
    }


}
