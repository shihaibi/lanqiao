package 贪心策略与动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 区间选点问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Problem[] works = new Problem[num];
        for (int i = 0; i < num; i++) {
            works[i] = new Problem();
            works[i].start = sc.nextInt();
            works[i].end = sc.nextInt();
            works[i].times = sc.nextInt();
        }
        Arrays.sort(works);
        get(works);
    }

    private static void get(Problem[] works) {
        int max = works[works.length -1].end;
        int[] axis = new int[max + 1];
        for (int i = 0; i < works.length; i++) {
            int s = works[i].start;
            int e = works[i].end;
            int cnt = sum(axis, s, e);
            cnt = works[i].times - cnt;
            while (cnt > 0) {
                if (axis[e] == 0) {
                    axis[e] = 1;
                    cnt--;
                }
                e--;
            }
        }
        System.out.println(sum(axis, 0, axis.length - 1));

    }

    private static int sum(int[] axis, int s, int e) {
        int cnt = 0;
        for (int i = s; i <= e; i++) {
            if (axis[i] == 1) {
               cnt++;
            }
        }
        return cnt;
    }

    private static class Problem implements Comparable<Problem> {
        int start;
        int end;
        int times;

        @Override
        public int compareTo(Problem o) {
            int x = this.end - o.end;
            if (x == 0) {
                return this.start - o.start;
            }
            return x;
        }
    }
}
