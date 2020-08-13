package 笔试题.美团;

import java.util.Scanner;

public class 伪中位数_快速排序应用 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int pre = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] < k) {
                swap(nums, start++, pre++);
            } else if (nums[start] == k) {
                start++;
            } else {
                swap(nums, start, end--);
            }
        }
        end++;
        int nlen = nums.length + 1;
        int i = 0;
        if (nlen/2 < start) {
            while (nlen/2 < start) {
                nlen++;
                i++;
            }
        } else if (nlen/2 >end) {
            while (nlen/2 > end) {
                nlen++;
                end++;
                i++;
            }
        }
        System.out.println(i);
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
