package 数学问题;

import java.util.Scanner;

import 数学问题.裴蜀公式;

public class 青蛙的约会 {
    public static void main(String[] args) {
        //(m - n) * xx + L * yy = y - x
        //m，n表示青蛙速度
        //L表示维度总线
        //x y 表示青蛙距离
        Scanner sc = new Scanner(System.in);
//        long x = sc.nextInt();
//        long y = sc.nextInt();
//        long m = sc.nextInt();
//        long n = sc.nextInt();
//        long L = sc.nextInt();
        long d = 裴蜀公式.getAnswer(-1, 5, 1);
        //a = m - n, b = L, m = y - x
        long x0 = 裴蜀公式.x;
        long b = 5;// b = L
        b /= d;
        b = b < 0 ? -b : b;
        x0 = (x0%b + b)%b;
        System.out.println(x0);


    }

}
