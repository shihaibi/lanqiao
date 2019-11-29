package 贪心策略与动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 区间调度问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Problem[] works = new Problem[num];
        for (int i = 0; i < num; i++) {
            works[i] = new Problem();
            works[i].start = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            works[i].end = sc.nextInt();
        }
        Arrays.sort(works);
        get(works);
    }
    private static class Problem implements Comparable<Problem> {
        int start;
        int end;

        @Override
        public int compareTo(Problem o) {
            int x = this.end - o.end;
            if (x == 0) {
                return this.start - o.start;
            }
            return x;
        }
    }
    private static void get(Problem[] works) {
        int count = 0;
        int curTime = 0;
        for (int i = 0; i < works.length; i++) {
            if (curTime > works[i].start) {
                continue;
            }
            count++;
            curTime = works[i].end;
        }
        System.out.println(count);
    }
}
