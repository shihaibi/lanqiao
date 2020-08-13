package 笔试题.美团;

import java.util.Arrays;
import java.util.Scanner;

public class 找第k小的排列组合 {
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int[] res = new int[2];
//        backtrace(nums, 0, res);

    }

    private static void backtrace(int[] nums, int i, int[] res) {
        if (i == 2) {
            k--;
            if (k == 0) {
                System.out.println("(" + res[0] +"," + res[1] + ")");
                System.exit(0);
            }
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            res[i] = nums[j];
            backtrace(nums, i + 1, res);
        }
    }
}
