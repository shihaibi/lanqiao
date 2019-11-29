package CCF;

import java.util.Scanner;

public class 小明种苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] sort = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                sort[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.print(process(sort));
    }

    private static String process(int[][] sort) {
        int sum = 0, maxshuguoIndex = 0, shuguoNum = 0;
        int[] shu = new int[sort.length];
        for (int i = 0; i < sort.length; i++) {
            for(int j = 1; j < sort[0].length; j++) {
                shu[i] += sort[i][j];
            }
            if (shu[i] < shuguoNum) {
                maxshuguoIndex = i + 1;
                shuguoNum = shu[i];
            }
            sum += sort[i][0] + shu[i];
        }
        return sum + " " + maxshuguoIndex + " " + -shuguoNum;
    }
}
