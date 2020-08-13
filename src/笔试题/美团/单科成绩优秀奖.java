package 笔试题.美团;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class 单科成绩优秀奖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int student = sc.nextInt();
        int item = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        TreeMap<Integer, Integer>[] maps = new TreeMap[item];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new TreeMap<Integer, Integer>();
        }
        for (int i = 0; i < student; i++) {
            for (int j = 0; j < item; j++) {
                maps[j].put(sc.nextInt(), i);
            }
        }
        int a = maps[1].lastKey();
        for (int i = 0; i < item; i++) {
            if (!set.contains(maps[i].lastEntry().getValue())) {
                set.add(maps[i].lastEntry().getValue());
            }

        }
        System.out.println(set.size());
    }
}
