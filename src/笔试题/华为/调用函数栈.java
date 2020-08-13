package 笔试题.华为;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 调用函数栈 {
    static int[] weight;
    static  int[][] arr;

    static int maxWeight = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1][];
        weight = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = new int[sc.nextInt()];
        }
        for (int i = 1; i < arr.length; i++) {
            int i1 = sc.nextInt();
            if (i1 != i) {
                System.out.println("NA");
                System.exit(0);
            }
            weight[i] = sc.nextInt();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.println("NA");
                    System.exit(0);
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            getWeight(i, set, 0);
        }

        System.out.println(maxWeight);
    }

    private static void getWeight(int index, HashSet<Integer> curSet, int curNum) {
        int res = 0;
        if (curSet.contains(index)) {
            System.out.println("R");
            System.exit(0);
        }
        curSet.add(index);
        curNum += weight[index];
        maxWeight = Math.max(curNum, maxWeight);
        for (int i = 0; i < arr[index].length; i++) {
            getWeight(arr[index][i], new HashSet<>(curSet), curNum);
        }
    }
}
