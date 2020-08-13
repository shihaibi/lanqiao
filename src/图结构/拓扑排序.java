package 图结构;

import java.util.Stack;

/**
 * 可以通过将visited设为三个状态，来判断是否有环
 * 如果visited = -1
 */
public class 拓扑排序 {
    public static int[][] data = new int[][]{
            {0,1,0,0},
            {0,0,0,1},
            {0,1,0,0},
            {0,0,1,0}
    };
    static Stack<Integer> index = new Stack<>();
    //static boolean[] visited = new boolean[data.length];
    static int[] visited = new int[data.length];
    public static void main(String[] args) {
        for (int i = 0; i < data.length; i++) {
            if (visited[i]==0) {
                boolean a = dfs(i);
                if (!a) {
                    System.out.println("有环");
                    return;
                }
            }
        }
        while(!index.isEmpty()) {
            System.out.println(index.pop());
        }
    }

    private static boolean dfs(int i) {
        visited[i] = -1;
        for (int j = 0; j < data[0].length; j++) {
            if (data[i][j] > 0){
                if (visited[j] == -1) {
                    return false;
                }else if(visited[j] == 0 && !dfs(j)) {
                    return false;
                }
            }
        }
        index.push(i);
        visited[i] = 1;
        return true;
    }
}
//public static void main(String[] args) {
//        for (int i = 0; i < data.length; i++) {
//            if (!visited[i])    dfs(i);
//        }
//        while(!index.isEmpty()) {
//            System.out.println(index.pop());
//        }
//    }
//
//    private static void dfs(int i) {
//        visited[i] = true;
//        for (int j = 0; j < data[0].length; j++) {
//            if (!visited[j] && data[i][j] > 0){
//                dfs(j);
//            }
//        }
//        index.push(i);
//    }
//}
