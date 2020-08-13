package 图结构;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 欧拉道路 {
    public static int[][] data = {
            {0,1,2,1},
            {1,0,0,0},
            {2,0,0,1},
            {1,0,1,0}
    };
    private static int n = 4;
    private static Stack<Integer> stack = new Stack<>();
    static void euler(int u) {
        stack.push(u);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (data[u][i] > 0) {
                data[u][i]--;
                data[i][u]--;
                euler(i);
                m++;
                data[u][i]++;
                data[i][u]++;
            }
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] != 0) {
                        System.out.println("没有道路");
                        System.exit(0);
                    }
                }
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());

            }
            System.exit(0);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        euler(1);

    }
}
