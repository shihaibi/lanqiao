package 贪心策略与动态规划;

import java.util.Scanner;

public class 硬币问题 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int curMoney = sc.nextInt();
        try {
            System.out.println(get(curMoney, 5));
        } catch (Exception e) {
            System.out.println("硬币不够了");
        }
    }

    private static int get(int curMoney, int i) throws Exception {
        if (curMoney == 0) {
            return 0;
        }
        if (i == 0) {
            if (curMoney < nums[0]) {
                return curMoney;
            } else {
                throw new Exception();
            }
        }
        int num = curMoney/coins[i];
        num = Math.min(num, nums[i]);
        return num + get(curMoney - num * coins[i], i - 1);
    }

    static int[] coins = new int[]{1,5,10,50,100,500};
    static int[] nums = new int[6];

}
