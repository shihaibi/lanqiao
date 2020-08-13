package 笔试题.快手;

import java.util.*;

public class 好序列的个数 {
    static long MOD = 1000000007;
    private static HashSet<Integer> visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        HashSet<Integer>[] obj = new HashSet[n + 1];
        visited = new HashSet<>();


        long all = pow(n, k);
        long wrong = 0;
        for (int i = 1; i <= n; i++) {
            obj[i] = new HashSet<Integer>();
        }
        for (int i = 1; i < n; i++) {
            int a=sc.nextInt(),b=sc.nextInt(),weight=sc.nextInt();
            if (weight == 0) {
                obj[a].add(b);
                obj[b].add(a);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i)) {
                wrong = (wrong + pow(dfs(obj,i), k)) % MOD;
            }
        }
        System.out.println((all - wrong + MOD) % MOD);


    }
    public static int dfs(HashSet<Integer>[] obj, int index) {
        visited.add(index);
        int res = 1;
        HashMap map = new HashMap();
        Set<Map.Entry> a = map.entrySet();
        for (Map.Entry x:
             a) {

        }
        for(Integer i : obj[index]) {
            if (!visited.contains(i)) {
                res += dfs(obj, i);
            }
        }
        return res;
    }
    public static long pow(long x, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }
}
