package 数学问题;

public class 裴蜀公式 {
    public static void main(String[] args) {
//        System.out.println(ext_gcd(2, 7));
//        getAnswer(2, 7, 1);
//        System.out.println(x  +" "+ y);
        inverseElement(12,2);
        System.out.println(x);
    }
    static long x = 0;
    static long y = 0;
    public static long ext_gcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long res = ext_gcd(b, a%b);
        long tmp = x;
        x = y;
        y = tmp - a/b * y;
        return res;
    }
    public static long getAnswer(long a, long b, long m) {
        long gcd = ext_gcd(a, b);
        if (m % gcd != 0) {
            System.out.println("无解");
        }
        long n = m/gcd;
        x *= n;
        y *= n;
        return gcd;

    }
    public static long inverseElement(long a, long mo) {
        long d = getAnswer(a, mo, 1);
        x = (x%mo + mo)%mo;
        return d;
    }
}
