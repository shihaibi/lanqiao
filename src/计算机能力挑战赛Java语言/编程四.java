package 计算机能力挑战赛Java语言;

import java.util.LinkedList;
import java.util.Scanner;


public class 编程四 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<group> minList = new LinkedList<>();
        LinkedList<group> maxList = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i = 0;
        int maxRes = 0;
        while (i < n) {
            int cur = sc.nextInt();
            while (!maxList.isEmpty() && maxList.getLast().value < cur) {
                maxList.removeLast();
            }
            while (!maxList.isEmpty() && maxList.peek().index + m <= i) {
                maxList.removeFirst();
            }
            maxList.addLast(new group(cur, i));
            while (!minList.isEmpty() && minList.getLast().value > cur) {
                minList.removeLast();
            }
            while (!minList.isEmpty() && minList.peek().index + m <= i) {
                minList.removeFirst();
            }
            minList.addLast(new group(cur, i));
            maxRes = Math.max(maxList.peek().value - minList.peek().value, maxRes);
            i++;
        }
        System.out.println(maxRes);

    }
    static class group{
        int value;
        int index;
        group(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
