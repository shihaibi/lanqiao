package 贪心策略与动态规划;

public class 最长公共子序列问题 {
    public static void main(String[] args) {
        System.out.println(get("QQASA1BC2", "QQASBA34C"));
        parseDp("QQASA1BC2");
    }



    static int[][] dp;
    private static int get(String str1, String str2) {
        dp = new int[str1.length()][str2.length()];
        if (str1.charAt(0) == str2.charAt(0)) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0))
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < str2.length(); i++) {
            if (str1.charAt(0) == str2.charAt(i))
                dp[0][i] = 1;
            else
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str1.length() - 1][str2.length() - 1];
    }
    private static void parseDp(String str1) {
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        StringBuffer sb = new StringBuffer();
        while ( i > 0 && j > 0) {
            if (Math.max(dp[i - 1][j], dp[i][j - 1]) < dp[i][j]) {
                sb.append(str1.charAt(i));
                j--;
                i--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }
        while (i > 0 && dp[i][0] == 1) {
            i--;
        }
        sb.append(str1.charAt(i + 1));

        System.out.println(sb.reverse().toString());
    }
}
