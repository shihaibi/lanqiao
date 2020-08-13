package 笔试题.快手;

import java.util.Scanner;

public class 合并两个内容流 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs1 = sc.nextLine().split(" ");
        String[] strs2 = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int len = Math.min(strs1.length/4, strs2.length);
        for (int i = 0; i < len; i++) {
            sb.append(strs1[4 * i]).append(" ").
                    append(strs1[4 * i + 1]).append(" ").
                    append(strs1[4 * i + 2]).append(" ").
                    append(strs1[4 * i + 3]).append(" ").
                    append(strs2[i]).append(" ");
        }
        if (strs1.length > len * 4) {
            for (int i = len * 4; i < strs1.length; i++) {
                sb.append(strs1[i]).append(" ");
            }
        }
        if (strs2.length > len) {
            for (int i = len; i < strs2.length; i++) {
                sb.append(strs2[i]).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
