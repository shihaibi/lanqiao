package 贪心策略与动态规划;

import java.util.Arrays;

public class 乘船问题 {
    public static void main(String[] args) {
        int[] w = {1,2,3,4,5,6,7,8,9,10};
        int n = w.length - 1;
        int c = 10;
        int boatNum = 0;
        Arrays.sort(w);
        for (int i = n, index = 0; i >= index; i--,boatNum++) {
            if (w[i] + w[index] <= c) {
                index++;
            }
        }
        System.out.println(boatNum);
    }
}
