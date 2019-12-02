package 贪心策略与动态规划;

import java.util.Arrays;

public class 最长上升子序列 {
    static int[] arr = {4,2,3,1,5,6,8,7,8,7,9,10,20,16};
    static int maxValue = 20;
    public static void main(String[] args) {
        System.out.println(get1());
        System.out.println(get2());
        System.out.println(get3());
    }



    private static int get1() {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    private static int get2() {
        int[][] dp = new int[arr.length][maxValue + 1];
        for (int i = 0; i<= maxValue; i++) {
            if (arr[0] > i)
                dp[0][i] = 0;
            else
                dp[0][i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= maxValue; j++) {
                if (j >= arr[i])
                    dp[i][j] = Math.max(dp[i - 1][arr[i] - 1] + 1, dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[arr.length - 1][maxValue];
    }
    private static int get3() {
        int[] dp = new int[arr.length + 1];
        dp[1] = arr[0];
        int p = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > dp[p]) {
                dp[++p] = arr[i];
            } else {
                for (int j = 0; j <= p; j++) {
                    if (dp[j] >= arr[i]) {
                        dp[j] = arr[i];
                    }
                }
            }

        }
        return p;
    }
}
