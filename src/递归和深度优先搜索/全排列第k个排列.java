package 递归和深度优先搜索;

public class 全排列第k个排列 {
    public static void main(String[] args) {
        String s = "123";
        get("", s.toCharArray());
    }
    final static int k = 3;
    static int count = 0;
    private static void get(String prefix, char[] arr) {
        if (prefix.length() == arr.length) {
            count++;
        }
        if (count == k) {
            System.out.println(prefix);
            System.exit(0);
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (count(prefix.toCharArray(),ch) < count(arr, ch)) {
                get(prefix + ch, arr);
            }
        }
    }
    private static int count(char[] arr, char ch) {
        int cnt = 0;
        for (char c : arr) {
            if (c == ch) cnt++;
        }
        return cnt;
    }
}
