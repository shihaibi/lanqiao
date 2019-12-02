package 贪心策略与动态规划;

import java.util.Arrays;

public class 数字三角形问题 {
    static int[][] arr = new int[][]{
            {7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}
    };
    static int n = arr.length;
    static int[][] ans = new int[n][n];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(get1(0, 0));
        System.out.println(get2());
        System.out.println(get3());
    }


    private static int get1(int H, int index) {
        if (H == n){
            return 0;
        }
        if (ans[H][index] == 0)
            ans[H][index] =  arr[H][index] + Math.max(get1(H + 1, index + 1),
                get1(H + 1, index));
        return ans[H][index];
    }
    private static int get2() {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == n - 1) {
                    ans[i][j] = arr[i][j];
                } else {
                    ans[i][j] = arr[i][j] + Math.max(ans[i + 1][j], ans[i + 1][j + 1]);
                }
            }
        }
        return ans[0][0];
    }
    private static int get3() {
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == n - 1) {
                    res[j] = arr[i][j];
                } else {
                    res[j] = arr[i][j] + Math.max(res[j], res[j + 1]);
                }
            }
        }
        return res[0];
    }



}
