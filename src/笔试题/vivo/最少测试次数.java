package 笔试题.vivo;

import java.util.Scanner;

public class 最少测试次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(getIt(k, 0, n));
    }

    private static int getIt(int k, int m, int n) {
        if (m >= n) {
            return 1;
        }
        if (k == 1) {
            return n - m;
        }
        int mid = m + (n - m) / 2;
        return 1 + Math.max(getIt(k, mid  + 1, n), getIt(k - 1, m, mid ));
    }
}
