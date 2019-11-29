package 递归和深度优先搜索;

import java.util.Arrays;

public class 素数环 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        dfs(arr, 1);
    }

    private static void dfs(int[] arr, int index) {
        if (index == arr.length ) {
            if (isP(arr[index - 1] + arr[0]))
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = index; i < arr.length; i++){
            if (index == 0 || isP(arr[index - 1] + arr[i])) {
                swap(arr, index, i);
                dfs(arr, index + 1);
                swap(arr, index, i);
            }
        }
    }

    private static boolean isP(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) return false;
        }
        return true;
    }

    private static void swap(int[] arr, int index, int i) {
        int tmp = arr[index];
        arr[index] = arr[i];
        arr[i] = tmp;
    }
}
