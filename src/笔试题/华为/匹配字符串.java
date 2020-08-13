package 笔试题.华为;

import java.util.Arrays;
import java.util.Scanner;

public class 匹配字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String str = str1[0];
        String[] arr = str1[1].split("(?<=],)");
        for (int i = 0; i < arr.length; i++) {
            String[] curStr = arr[i].split("\\[");
            if (!curStr[0].equals(str)) {
                System.out.println("FAIL");
            } else {
                String[] amv = curStr[1].split(",");
                if (amv.length == 3) {
                    String[] curAmv = new String[3];
                    String[] addr = amv[0].split("\\=");
                    if (addr.length == 2 &&addr[0].equals("addr")) {
                        curAmv[0] = addr[1];
                    }
                    String[] mask = amv[1].split("\\=");
                    if (mask.length == 2 &&mask[0].equals("mask")) {
                        curAmv[1] = mask[1];
                    }
                    String[] val = amv[2].split("\\=");
                    if (val.length == 2 &&val[0].equals("val")) {
                        curAmv[2] = val[1].charAt(val[1].length() - 1) == ']' ?
                                val[1].substring(0, val[1].length() - 1) : val[1];
                    }
                    if (check(curAmv)) {
                        System.out.println(curAmv[0] + " " + curAmv[1] + " " + curAmv[2]);
                    } else {
                        System.out.println("FAIL");
                    }
                } else {
                    System.out.println("FAIL");
                }

            }
        }
    }

    private static boolean check(String[] curAmv) {
        for (int i = 0; i < curAmv.length; i++) {
            if (curAmv[i].length() < 3) {
                return false;
            }
            String str = curAmv[i].substring(0, 2);
            if (!str.equals("0x") && !str.equals("0X")) {
                return false;
            }
        }
        return true;
    }
}
