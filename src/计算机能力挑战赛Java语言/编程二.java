package 计算机能力挑战赛Java语言;

import java.util.Scanner;

public class 编程二 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        System.out.println(get(data));
    }

    private static int get(int[] data) {
        boolean[] res = isHeshu(data);
        int result = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (res[i]) {
                count++;
                if (count >= 3) {
                    result++;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }
    private static boolean[] isHeshu(int[] data) {
        boolean[] res = new boolean[data.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 2; j <= Math.sqrt(data[i]); j++) {
                if (data[i]%j == 0) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res;
    }
}
