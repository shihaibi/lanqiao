package 笔试题.阅文;

import java.util.Scanner;

public class yichu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(",");
        long[] ay = new long[arr.length];
        for (int i = 0; i < ay.length; i++) {
            ay[i] = Integer.valueOf(arr[i]);
        }
        System.out.println(findIt(ay));
    }

    private static int findIt(long[] ay) {
        long[] left = new long[ay.length];
        long[] right = new long[ay.length];
        left[0] = 1;
        left[1] = ay[0];
        for (int i = 2; i < ay.length; i++) {
            left[i] = ay[i - 1] * left[i - 1];
        }
        right[ay.length - 1] = 0;
        right[ay.length - 2] = ay[ay.length - 1];
        for (int i = ay.length - 3; i >= 0 ; i--) {
            right[i] = right[i + 1] * ay[i + 1];
        }
        right[ay.length - 1] = left[ay.length - 1];
        for (int i = 0; i < ay.length - 1; i++) {
            right[i] *= left[i];
        }
        long res = right[0];
        int index = 0;
        for (int i = 0; i < right.length; i++) {
            if (res < right[i]){
                res = right[i];
                index = i;
            }
        }
        return index;

    }
}
