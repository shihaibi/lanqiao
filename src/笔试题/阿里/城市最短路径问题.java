package 笔试题.阿里;

import java.util.*;

public class 城市最短路径问题 {
    static boolean[][] graph;
    static int n;
    static int distance[][];
    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        distance = new int[n][n];
        graph = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        HashMap<Long, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long curAi = sc.nextInt();
            if (!map.containsKey(curAi)) {
                map.put(curAi, new HashSet<Integer>());
            }
            map.get(curAi).add(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u - 1][v - 1] = true;
            graph[v - 1][u - 1] = true;
        }
        for (int i = 0; i < graph.length; i++) {
            shortestPath(i);
        }
        for (Map.Entry<Long, Set<Integer>> entry: map.entrySet()) {
            for (Integer i: entry.getValue()) {
                for (Integer j: entry.getValue()) {
                    if (i == j)continue;
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }
        System.out.println(minDistance);
    }
    private static void shortestPath(int start) {

        distance[start][start] = 0;
        Set<Integer> visited = new HashSet<>();
        while (visited.size() < n) {
            int index = check(start,visited, distance);
            for (int i = 0; i < graph.length; i++) {
                if (i == index) continue;
                if(graph[index][i] && 1 + distance[start][index] < distance[start][i] ) {
                    distance[start][i] = 1 + distance[start][index];
                }
            }
        }

    }
    private static int check(int start, Set<Integer> visited, int[][] distance) {
        int index = 0 ;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if (!visited.contains(i) && distance[start][i] < minDistance) {
                index = i;
                minDistance = distance[start][i];
            }
        }
        visited.add(index);
        return index;
    }

}
