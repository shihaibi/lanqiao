package 贪心策略与动态规划;
/**
 * dp[curIndex][curValue] = Math.max(curIndexValue +
 * dp[curIndex - 1][curValue - curIndexValue],
 * dp[curIndex - 1][curValue])
 *
 */

import java.util.Arrays;

public class 背包问题01 {
    public static void main(String[] args) {
        //法1
        get2();
        System.out.println(value[w.length - 1][W]);

        //法2
        for (int i = 0; i < w.length; i++) {
            Arrays.fill(value[i], -1);
        }
        get1(0, W);
        System.out.println(value[0][5]);
    }
    static int[] w = {2,1,3,2};
    static int[] v = {3,2,4,2};
    static int W = 5;
    static int[][] value = new int[w.length][W + 1];
    static int get1(int curIndex, int curContains) {
        if (curIndex == w.length) return 0;
        if (curContains <= 0) return 0;
        if (value[curIndex][curContains] == -1) {
            if (curContains >= w[curIndex]) {
                int v1 = v[curIndex] + get1(curIndex + 1,
                        curContains - w[curIndex]);
                int v2 = get1(curIndex + 1, curContains);
                value[curIndex][curContains] = Math.max(v1, v2);
            } else {
                value[curIndex][curContains] = get1(curIndex + 1, curContains);
            }
        }
        return value[curIndex][curContains];
    }
    static void get2(){
        for (int i = 1; i <= W; i++) {
            for (int j = 0; j < w.length; j++) {
                if (j == 0) {
                    if (w[0] <= i) {
                        value[0][i] = v[0];
                    } else {
                        value[0][i] = 0;
                    }
                    continue;
                }
                if( w[j] <= i) {
                    value[j][i] = Math.max(v[j] + value[j - 1][i - w[j]],
                            value[j - 1][i]);
                } else {
                    value[j][i] = value[j - 1][i];
                }
            }
        }
    }

}
