package 贪心策略与动态规划;

import java.util.Scanner;

public class 快速渡河问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] people = new int[num];
        for (int i = 0; i < num; i++) {
            people[i] = sc.nextInt();
        }
        System.out.println(get(people));
    }

    private static int get(int[] people) {
        int curPeople = people.length;
        int res = 0;
        while (curPeople > 0) {
            if (curPeople == 2) {
                res += people[1];
                break;
            } else if (curPeople == 3) {
                res += people[0] + people[1] + people[2];
                break;
            } else if (curPeople == 1) {
                return people[0];
            } else {
                int s1 = 2 * people[0] + people[curPeople - 1] + people[curPeople - 2];
                int s2 = people[0] + 2 * people[1] + people[curPeople - 1];
                res += Math.min(s1, s2);
                curPeople -= 2;
            }
        }
        return res;
    }
}
