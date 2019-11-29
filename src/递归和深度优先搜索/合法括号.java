package 递归和深度优先搜索;

import java.util.HashSet;

public class 合法括号 {
    public static void main(String[] args) {
        HashSet<String> set = getSet(2);
        System.out.println(set.toString());
        System.out.println(getSet1(30).toString());
    }
    public static HashSet<String> getSet(int n) {
        HashSet<String> res = new HashSet<>();
        if (n == 1) {
            res.add("()");
            return res;
        }
        HashSet<String> set = getSet(n - 1);
        for (String s : set) {
            res.add("()" + s);
            res.add("(" + s + ")");
            res.add(s + "()");
        }
        return res;
    }
    public static HashSet<String> getSet1(int n) {
        HashSet<String> res = new HashSet<>();
        res.add("()");
        for (int i = 1; i < n; i++) {
            HashSet<String> cur = new HashSet<>();
            for (String s:res) {
                cur.add("()" + s);
                cur.add("(" + s + ")");
                cur.add(s + "()");
            }
            res = cur;
        }
        return res;
    }
}
