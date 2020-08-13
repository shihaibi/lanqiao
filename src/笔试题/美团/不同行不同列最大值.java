package 笔试题.美团;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 不同行不同列最大值 {
    static float maxValue = Integer.MIN_VALUE ;
    static int m;
    static int[] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        float[][] arr = new float[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextFloat();
            }
        }
        int[] row = new int[m];

        HashSet<Integer> set = new HashSet<>();
        backtrace(row, set, arr, 0, 0);
        String format = new DecimalFormat("#.000").format(maxValue);
        while (format.charAt(format.length() - 1) == '0') {
            format = format.substring(0, format.length() - 1);
        }
        System.out.println(format);
        for (int i = 0; i < m; i++) {
            System.out.println((i + 1) + " " + (res[i] + 1));
        }
    }

    private static void backtrace(int[] row, HashSet<Integer> set, float[][] arr,float curValue,  int i) {
        if (i == m) {
            if (maxValue < curValue) {
                maxValue = curValue;
                res = Arrays.copyOf(row, row.length);
            }
            return;
        }
        for (int j = 0; j < m; j++) {
           if (set.contains(j)) continue;
           set.add(j);
           row[i] = j;
           backtrace(row, set, arr, curValue + arr[i][j], i + 1);
           set.remove(j);
        }
    }
}
