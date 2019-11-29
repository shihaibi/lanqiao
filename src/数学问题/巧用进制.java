package 数学问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 巧用进制 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        make(num);

    }
    private static void make(int num) {
        char[] arr = new StringBuilder(Integer.toString(num, 3))
                .reverse().toString().toCharArray();
        List<Integer> list = new ArrayList<>();
        boolean sign = false;
        int cur;
        for (int i = 0; i < arr.length; i++) {
            cur = sign ? arr[i] + 1 : arr[i];
            sign = false;
            if (cur == '2') {
                list.add(0, -1);
                sign = true;
            } else if (cur == '3') {
                list.add(0, 0);
                sign = true;
            } else {
                list.add(0, arr[i] - '0');
            }
        }
        if (sign) {
            list.add(0, 1);
        }
        int pow = list.size() - 1;
        StringBuilder sb = new StringBuilder();
        sb.append((int)Math.pow(3, pow--));
        for (int i = 1; i < list.size(); i++) {
            int j = list.get(i);
            if (j == -1) {
                sb.append('-').append((int)Math.pow(3, pow--));
            } else if(j == 1) {
                sb.append('+').append((int)Math.pow(3, pow--));
            } else {
                pow--;
            }
        }
        System.out.print(sb.toString());
    }
}
