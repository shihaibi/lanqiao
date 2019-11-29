package 数学问题;

import java.util.Arrays;

public class 埃氏素数筛法 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getPrime(100)));
        int[] arr = getPrime(1300000);
        System.out.println(getIndex(arr, 100000));
    }
    public static int[] getPrime(int num) {
        int[] arr = new int[num];
        for(int i = 2; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            for (int j = 2; j * i < arr.length; j++) {
                if (arr[i * j] != -1){
                    arr[i * j] = -1;
                }
            }
        }
        return arr;
    }
    public static int getIndex(int[] arr, int num) {
        int res = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                res++;
            }
            if (res == num) {
                return i;
            }
        }
        return -1;
    }

}
