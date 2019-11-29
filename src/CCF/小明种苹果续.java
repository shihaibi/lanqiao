package CCF;

import java.util.Scanner;

public class 小明种苹果续 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data;
        int[] drop = new int[n];
        int sum = 0, mark = 0, groupNum = 0, dropNum = 0;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            data = new int[m];
            for (int j = 0; j < m; j++) {
                data[j] = sc.nextInt();
            }
            int[] res = process(data);
            drop[i] = res[1];
            if (drop[i] == 1) {
                mark++;
                dropNum++;
                if (mark >=3) {
                    groupNum++;
                }
            } else {
                mark = 0;
            }
            sum += res[0];
        }
        if(drop[0] == 1&&drop[drop.length -1] == 1)
        {
            if (drop[1] == 1) {
                groupNum++;
            }
            if (drop[drop.length - 2] == 1) {
                groupNum++;
            }
        }
        sc.close();
        System.out.print(sum + " " + dropNum + " " + groupNum);
    }
    private static int[] process(int[] data) {
        int index = data[0], mark = 0, groupNum = 0, drop = 0;
        for (int j = 1; j < data.length; j++) {
            if (data[j] > 0) {
                if (drop == 0){
                    drop = index == data[j] ? 0 : 1;
                }
                index = data[j];
            } else {
                index += data[j];
            }
        }
        return new int[]{index, drop};
    }
}
