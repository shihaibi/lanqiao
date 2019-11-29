package 数学问题;

import 数学问题.裴蜀公式;

/**
 * 其中n = A%9973
 */
public class A除以B {
    public static void main(String[] args) {
        long n = 87;
        long B = 123456789;
        裴蜀公式.inverseElement(B, 9973);
        long x = 裴蜀公式.x;
        System.out.println(x*n%9973);
    }
}
