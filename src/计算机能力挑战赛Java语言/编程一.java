package 计算机能力挑战赛Java语言;


import java.util.Scanner;

public class 编程一 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(get(n));
    }

    private static int get(int n) {
        int i = 1;
        int curNum = 1;
        while (curNum <= n) {
            i++;
            curNum = i * i * i;
        }
        return i - 1;
    }
}
