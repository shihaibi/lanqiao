package 图结构;

import java.util.Scanner;

/**
 * 四联通图之所以要分四种情况
 */
public class 连通检测 {
    public static boolean check(char[][] graph, boolean[][] lables, int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int x2 = point[2];
        int y2 = point[3];
        if (point[0] == point[2] && point[1] == point[3]) {
            return true;
        }
        int value = graph[x1][x2];
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        boolean f4 = false;
        if (x1 - 1 >= 0 && !lables[x1 - 1][y1] && graph[x1-1][y1] == value) {
            point[0] = x1 - 1;
            lables[x1 - 1][y1] = true;
            f1 = check(graph, lables, point);
            lables[x1 - 1][y1] = false;
            point[0] = x1;
        }
        /**
         * 没写完
         */
        return false;
    }
}
