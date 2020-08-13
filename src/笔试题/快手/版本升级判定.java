package 笔试题.快手;

import java.util.Scanner;

public class 版本升级判定 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            boolean res = false;
            String[] x = sc.nextLine().split(" ");
            String[] ver1 = x[0].split("\\.");
            String[] ver2 = x[1].split("\\.");
            int len = Math.min(ver1.length, ver2.length);
            int sign = 0;
            for (int j = 0; j < len; j++) {
                if (Integer.parseInt(ver1[j]) < Integer.parseInt(ver2[j])) {
                    res = true;
                    sign = 1;
                    break;
                } else if (Integer.parseInt(ver1[j]) > Integer.parseInt(ver2[j])) {
                    sign = 1;
                    res = false;
                    break;
                }
            }
            if (ver2.length > len && sign == 0) {
                int count = 0;
                for (int j = len; j < ver2.length; j++) {
                    count += Integer.parseInt(ver2[j]);
                }
                if(count == 0) {
                    res = false;
                }else
                    res = true;
            }
            System.out.println(res);
        }
    }
}
