package 笔试题.华为;

import java.util.Scanner;

public class 二进制 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        boolean signal = false;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!signal && str.charAt(i) == '0') {
                signal = true;
            }
            if (signal && str.charAt(i) == '1') {
                count++;
            }
        }
        if (!signal) {
            System.out.println(str);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length() - count - 1; i++) {
                sb.append(1);
            }
            sb.append(0);
            for (int i = 0; i < count; i++) {
                sb.append(1);
            }
            System.out.println(sb.toString());
        }
    }
}
