package 数学问题;

public class 快速求a的n次方 {
public static int ex(int a, int n) {
    if (n == 1) {
        return a;
    }
    int temp = a;
    int exponent = 1;
    while ((exponent << 1) < n) {
        temp = temp * temp;
        exponent = exponent << 1;
    }
    int res =temp * ex(a, n - exponent);
    return res;
}
public static long ex2(long a, long b) {
    long res = 1;
    while(b != 0) {
        if ((b & 1) == 1) {
            res *= a;
        }
        a *= a;
        b >>= 1;
    }
    return res;
}

    public static void main(String[] args) {
        System.out.println(ex(2,10));
        System.out.println(ex2(2, 10));
    }
}
