package 笔试题.广联达;

import java.util.*;

public class 弱智题 {
    public static void main(String[] args) {
        int[] rooms = new int[]{0,1,0,1,1,0,0,1};
        int[] res = func(rooms, 7);
        System.out.println();
    }

    private static int[] func(int[] rooms, int N) {
        int[] next = new int[rooms.length];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < rooms.length - 1; j++) {
                if (rooms[j - 1] == rooms[j + 1]) {
                    next[j] = 1;
                }
            }
            int[] tmp = rooms;
            rooms = next;
            next = tmp;
            Arrays.fill(next, 0);
        }
        return rooms;
    }
}
