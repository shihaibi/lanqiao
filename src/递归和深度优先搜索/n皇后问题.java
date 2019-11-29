package 递归和深度优先搜索;

import java.util.Scanner;

public class n皇后问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        qipan = new int[num + 1];
        get(1);
        System.out.println(count);


    }
    private static int[] qipan;
    private static int count = 0;
    private static void get(int cur) {
        if (cur == qipan.length) {
            count++;
        }
        for (int i = 1; i < qipan.length; i++) {

            if (check(cur, i)) {
                qipan[cur] = i;
                get(cur + 1);
                qipan[cur] = 0;
            }

        }

    }

    private static boolean check(int cur, int i) {
        for (int j = 1; j < cur; j++) {
            if (qipan[j] == i || qipan[j] + j == cur + i
                    || qipan[j] - j == i - cur) {
                return false;
            }
        }
        return true;
    }
}
