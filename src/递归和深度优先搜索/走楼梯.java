package 递归和深度优先搜索;

/**
 * 一个小孩上楼梯，楼梯有n个台阶，小孩一次可以上1阶，2阶，3阶。
 * 给定一个正整数n, 返回一个数，表示上楼梯的方式数
 * 结果mod 100000007
 */
public class 走楼梯 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(recursion1(20));
        System.out.println(recursion2(1000000));
    }
    public static long recursion1(int n ) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) return 2;
        return recursion1(n - 1) % mod + recursion1(n - 2) % mod +
                recursion1(n - 3) % mod;
    }
    public static long recursion2(int n ) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int c = 4;
        int tmp = 0;
        for (int i = 4; i <= n; i++) {
            tmp = a;
            a = b;
            b = c;
            c = tmp % mod + a % mod + b % mod;
        }
        return c;
    }
}
