package 字符串;

/**
 * 输入：aabaabaabaab
 * 输出：
 * 2 2
 * 6 2
 * 9 3
 * 12 4
 */
public class Period周期性 {
    public static void main(String[] args) {
        char[] arr = "aabaabaabaab".toCharArray();
        find(arr);
    }
    public static void find(char[] arr) {
        //int[] next = new int[arr.length + 1];
        int[] next = makeNext(arr);
        for (int i = 0; i < next.length; i++) {
            int p = i - next[i];
            if (i%p == 0 && i/p > 1) {
                System.out.println(i + " " + i/p);
            }
        }
    }
    public static int[] makeNext(char[] arr) {
        int[] next = new int[arr.length + 1];
        next[0] = -1;
        next[1] = 0;
        int cur = 1;
        int curNext = 0;
        while (cur < arr.length) {
            if (curNext >= 0 && arr[cur] != arr[curNext]) {
                curNext = next[curNext];
            }else {
                next[++cur] = ++curNext;
            }
        }
        return next;
    }
}
