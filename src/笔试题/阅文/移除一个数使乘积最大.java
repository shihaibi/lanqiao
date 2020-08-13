package 笔试题.阅文;

import java.util.Scanner;

public class 移除一个数使乘积最大 {
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
        long res = Integer.MAX_VALUE ;
        res++;
        int index = 0;
        boolean isOdd = true;
        int isZero = 0;
        int zeroindex = 0;
        for (int i = 0; i < ay.length; i++) {
            if (ay[i] == 0) {
                isZero++;
                zeroindex = i;
            }
            if (ay[i] < 0) {
                isOdd = !isOdd;
            }
        }
        if (isZero > 1) {
            return 0;
        } else if (isZero == 1 && !isOdd) {
            for (int i = 0; i < ay.length; i++) {
                if (ay[i] != 0) {
                    return i;
                }
            }
        } else if (isZero == 1) {
            return zeroindex;
        }
        if (isOdd) {
            for (int i = 0; i < ay.length; i++) {
                if (ay[i] > 0 && res > ay[i]) {
                    res = ay[i];
                    index = i;
                }
            }
            return index;
        } else {
            for (int i = 0; i < ay.length; i++) {
                if (ay[i] < 0 && res > Math.abs((long)ay[i])) {
                    res = ay[i];
                    index = i;
                }
            }
            return index;
        }
    }
}
