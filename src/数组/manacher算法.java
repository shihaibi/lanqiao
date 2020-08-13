package 数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manacher算法 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> strings = maxLength(str);
        if (strings.size() == 0 || strings.get(0).length() == 1) {
            System.out.println("null");
        } else {
            for(String s : strings) {
                System.out.println(s);
            }
        }


    }
    public static char[] getManacherString(String str) {
        char[] arr = str.toCharArray();
        char[] newArr = new char[arr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = (i & 1) == 1 ? arr[index++] : '#';
        }
        return newArr;
    }
    public static List<String> maxLength(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] arr = getManacherString(str);
        int[] pArr = new int[arr.length];
        int center = -1;
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            pArr[i] = right > i ? Math.min(pArr[2 * center - i], right - i) : 1;
            while (i + pArr[i] < arr.length && i - pArr[i] > -1) {
                if (arr[i + pArr[i]] == arr[i - pArr[i]]) {
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > right) {
                right = i + pArr[i];
                center = i;
            }

            max = Math.max(max,pArr[i]);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] == max) {
                StringBuilder sb = new StringBuilder();
                for (int j = i - pArr[i] + 1 ; j < i + pArr[i]; j++) {
                    if (arr[j] != '#') {
                        sb.append(arr[j]);
                    }
                }
                res.add(sb.toString());
            }
        }
        return res;
    }
}
