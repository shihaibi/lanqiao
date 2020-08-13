package 图结构;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra算法 {
    static int[][] graph = {
            {0, 2, 5, 0, 0, 0, 0},
            {2, 0, 4, 6, 10, 0, 0},
            {5, 4, 0, 2, 0, 0, 0},
            {0, 6, 2, 0, 0, 1, 0},
            {0, 10, 0, 0, 0, 3, 5},
            {0, 0, 0, 1, 3, 0, 9},
            {0, 0, 0, 0, 5, 9, 0}
    };
    static int n = graph.length;
    static int[] pre = new int[n];
    static int[] distance = new int[n];
    static Set<Integer> visited = new HashSet<>();
    static {
        Arrays.fill(distance,Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        shortestPath(1);
    }
    private static void shortestPath(int start) {
        distance[start] = 0;
        while (visited.size() < n) {
            int index = check(visited, distance);
            for (int i = 0; i < graph.length; i++) {
                if (i == index) continue;
                if(graph[index][i] > 0 && graph[index][i] + distance[index] < distance[i] ) {
                    distance[i] = graph[index][i] + distance[index];
                    pre[i] = index;
                }
            }
        }

    }
    private static int check(Set<Integer> visited, int[] distance) {
        int index = 0 ;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if (!visited.contains(i) && distance[i] < minDistance) {
                index = i;
                minDistance = distance[i];
            }
        }
        visited.add(index);
        return index;
    }
}
