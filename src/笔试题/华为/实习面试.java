package 笔试题.华为;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class 实习面试 {
    public static void main(String[] args) {
        int[] func = func(new int[]{1, 2, 3, 0, 2, 0, 3});
        System.out.println(Arrays.toString(func));

    }
    public static int[] func(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        for(int i = start; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
