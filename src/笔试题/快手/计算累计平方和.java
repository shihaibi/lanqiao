package 笔试题.快手;

import java.util.HashSet;
import java.util.Scanner;

public class 计算累计平方和 {
    static int[][] help = new int[10][2];
    static HashSet<Integer> set = new HashSet<>();
    static {
        for (int i = 1; i < 10; i++) {
            help[i][0] = i;
            help[i][1] = i * i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(function(sc.nextInt()));
            set.clear();
        }
    }
    public static boolean function(Integer x) {
        while (x != 1 && !set.contains(x)) {
            set.add(x);
            int cur = 0;
            while (x != 0) {
                cur += help[x%10][1];
                x/= 10;
            }
            x = cur;
        }
        if (x == 1) {
            return true;
        } else {
            return false;
        }
    }
}
