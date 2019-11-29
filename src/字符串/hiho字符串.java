package 字符串;

/**
 * 找到最短的hiho字符串：恰好包含两个h一个i一个o
 * 输入该字串，输出最短的长度，如果不存在就输出-1
 * 输入：hapyhahaiohell
 * 输出：5
 *
 */
public class hiho字符串 {
    public static void main(String[] args) {
        char[] str = "hapyhahaiohell".toCharArray();
        System.out.print(get(str));
    }

    public static int get(char[] arr) {
        int j = -1;
        int i = 0;
        int res = Integer.MAX_VALUE;
        while (i < arr.length) {
            if(check(arr[i])) {//检查是否为hiho其中一个
                if (j == -1) {
                    j = i + 1;
                }
                while (j < arr.length) {
                    if (check(arr[j]) && contains(arr, i, j)) {
                        if (j - i + 1 < res && check(arr, i, j)) {
                            res = j - i + 1;
                        }
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static boolean check(char c) {
        if (c == 'h' || c == 'i' || c == 'o') {
            return true;
        }
        return false;
    }
    public static boolean contains(char[] arr, int start, int end) {
        int hTime = 0, iTime = 0, oTime = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == 'h')
                hTime++;
            else if (arr[i] == 'i')
                iTime++;
            else if (arr[i] == 'o')
                oTime++;
        }
        if (hTime >= 2 && oTime >= 1 && iTime >= 1) {
            return true;
        }
        return false;
    }
    public static boolean check(char[] arr, int start, int end) {
        int hTime = 0, iTime = 0, oTime = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == 'h')
                hTime++;
            else if (arr[i] == 'i')
                iTime++;
            else if (arr[i] == 'o')
                oTime++;
        }
        if (hTime == 2 && oTime == 1 && iTime == 1) {
            return true;
        }
        return false;
    }
}
