package 笔试题.广联达;

import java.util.*;

public class 所有括号 {
    public static void main(String[] args) {
        func(4);
    }
    public static List<String> func(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrace(0, 0, res, sb, n);
        return res;
    }
    public static void backtrace(int left, int right, List<String> list, StringBuilder sb, int n) {
        if (sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }
        if (right < left) {
            sb.append("}");
            backtrace(left, right + 1, list, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (n > left) {
            sb.append("{");
            backtrace(left + 1, right, list, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
