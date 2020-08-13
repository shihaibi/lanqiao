package 笔试题.广联达;

public class 数组期望升序 {
    public static void main(String[] args) {
        int[] a = new int[]{23,24,25,21,12,22,31,23};
        int[] b = func(a);
    }
    public static int[] func(int[] stock) {
        int[] res = new int[stock.length];
        for (int i = 0; i < stock.length; i++) {
            for (int j = i + 1; j < stock.length; j++) {
                if (stock[j] > stock[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
