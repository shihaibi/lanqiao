package 笔试题.华为;

import java.util.Scanner;

/**
 *
 * 题目：输入N,M，求N+N^2+N^3+...+N^M的结果（取余1000000007），1<N<=65536，1<M<=100000
 *
 * 输入格式：每行输入N M，直到N M均等于0时跳出
 * 输出格式：每行输出对应的结果
 */
public class 编码数目 {
    static int mod = 1000000007;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long res = 0;
        for (int i = 1; i <= m; i++) {
            res = (res + pow(n, i)) % mod;
        }
        System.out.println(res);
    }
    public static long pow(long n, long x) {
        long res = 1;
        while (x != 0) {
            if( (x & 1) == 1) {
                res = res * n % mod;
            }
            x >>= 1;
            n = n * n % mod;
        }
        return res;
    }
}
