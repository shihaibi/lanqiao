package 笔试题.vivo;

import java.util.Scanner;

public class 可新种的花草 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getIt(arr));
    }

    private static int getIt(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                continue;
            if ((i == 0 || arr[i - 1] == 0) && (i == arr.length - 1 || arr[i + 1] == 0)) {
                res++;
                arr[i] = 1;
            }
        }
        return res;
    }
}
