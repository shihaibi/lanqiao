package 字符串;

public class KMP算法 {
    public static void main(String[] args) {
        System.out.println(KMP("abcabababac", "abababab"));;
    }
    public static int KMP(String s1, String s2) {
        int[] next = next(s2);
        int s1Index = 0;
        int s2Index = 0;
        while (s1Index < s1.length()) {
            if (s2Index == -1 || s1.charAt(s1Index) == s2.charAt(s2Index)) {
                s1Index++;
                s2Index++;
            }else {
                s2Index = next[s2Index];
            }
            if (s2Index == s2.length()) {
                return s1Index - s2Index;
            }
        }
        return -1;
    }
    public static int[] next(String s) {
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        next[1] = 0;
        int cur = 1;
        int nextIndex = 0;
        while (cur < s.length()) {
            if (nextIndex == -1 || s.charAt(cur) == s.charAt(nextIndex)) {
                next[++cur] = ++nextIndex;
            } else {
                nextIndex = next[nextIndex];
            }
        }
        return next;
    }
}
