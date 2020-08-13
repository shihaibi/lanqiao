package 笔试题.阿里;

import java.util.Arrays;
import java.util.Scanner;

public class 勇士打怪兽 {
    static int maxMoney = Integer.MIN_VALUE;
    static int kill = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] power = new int[sc.nextInt()];
        for (int i = 0; i < power.length; i++) {
            power[i] = sc.nextInt();
        }
        Arrays.sort(power);
        for (int i = 0; i < power.length; i++) {
            if (a + kill >= power[i]) {
                kill++;
                if (power[i] < a) {
                    maxMoney= Math.max(maxMoney, kill );
                } else {
                    maxMoney = Math.max(maxMoney, a + kill - power[i]);

                }
            } else {
                break;
            }
        }
        System.out.println(maxMoney<0 ? 0 : maxMoney);
    }
}
