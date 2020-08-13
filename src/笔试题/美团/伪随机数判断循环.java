package 笔试题.美团;

import java.util.ArrayList;
import java.util.Scanner;

public class 伪随机数判断循环 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        boolean findIt = false;
        int curIndex = 0;
        int preIndex = 0;
        int mark = Integer.MAX_VALUE;
        while (!findIt) {
            x = (a * x + b) % m;
            list.add(x);
            if (preIndex ==mark) {
                System.out.println(mark);
                break;
            }
            if (curIndex != 0 && preIndex == 0 && x == list.get(preIndex)) {
                mark = curIndex;
                preIndex++;
            }else if (curIndex != 0 && x == list.get(preIndex)) {
                preIndex++;
            } else if (preIndex != 0){
                curIndex -= preIndex;
                preIndex = 0;
                mark = Integer.MAX_VALUE;
            }
            curIndex++;
        }
    }
}
