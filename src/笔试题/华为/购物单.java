package 笔试题.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 购物单 {
    static List<Good[]> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[N + 1];
        list = new ArrayList<Good[]>();
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            Good x = new Good(v, v * p);
            if (q == 0) {
                Good[] curGood = new Good[3];
                curGood[0] = x;
                list.add(curGood);
            } else {
                list.add(null);
                Good[] curGood = list.get(q - 1);
                if (curGood[1] == null) {
                    curGood[1] = x;
                } else {
                    curGood[2] = x;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) continue;
            for (int j = N; j >= 0 ; j--) {
                int max = dp[j];
                Good[] curGood = list.get(i);
                if (j >= curGood[0].v) {
                    max = Math.max(max, curGood[0].vp + dp[j - curGood[0].v]);
                }
                if (curGood[1] != null && j >= (curGood[0].v + curGood[1].v)) {
                    max = Math.max(max, curGood[0].vp + curGood[1].vp+ dp[j - curGood[0].v- curGood[1].v]);
                }
                if (curGood[2] != null && j >= (curGood[0].v + curGood[2].v)) {
                    max = Math.max(max, curGood[0].vp + curGood[2].vp+ dp[j - curGood[0].v- curGood[2].v]);
                }
                if (curGood[2] != null &&j >= (curGood[0].v + curGood[1].v + curGood[2].v)) {
                    max = Math.max(max, curGood[0].vp +curGood[1].vp + curGood[2].vp+ dp[j - curGood[0].v- curGood[1].v - curGood[2].v]);
                }
                dp[j] = max;
            }
        }
        System.out.println(dp[N]);
    }
    static class Good {
        int v;
        int vp;
        public Good(int v, int vp) {
            this.v = v;
            this.vp = vp;
        }
    }
}
