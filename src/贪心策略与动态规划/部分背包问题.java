package 贪心策略与动态规划;

import java.util.Arrays;

public class 部分背包问题 {
    public static void main(String[] args) {
        int C = 10;
        double maxValue = 0;
        int[] w = {1,2,3,4,5};
        int[] v = {3,4,3,1,4};
        Obj[] arr = new Obj[w.length];
        for (int i  = 0; i < w.length; i++) {
            arr[i] = new Obj(w[i], v[i]);
        }

        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i].w <= C) {
                C -= arr[i].w;
                maxValue += arr[i].v;
            } else {
                maxValue += arr[i].v * ((double)C/arr[i].w);
                break;
            }
        }
        System.out.println(maxValue);

    }
    private static class Obj implements Comparable<Obj>{
        int w;
        int v;
        public Obj(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Obj o) {
            if (this.v/(double)this.w - o.v/(double)o.w < 0){
                return -1;
            } else if (this.v/(double)this.w - o.v/(double)o.w > 0){
                return 1;
            } else
                return 0;
        }
    }
}
