package 递归和深度优先搜索;

import java.util.ArrayList;
import java.util.Scanner;

public class 困难的串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        int L = sc.nextInt();
        dfs(L , "");
    }
    private static int count;
    private static int curCount = 0;

    private static void dfs(int l, String s) {
        for (char c = 'A'; c < (char)(l + 'A'); c++) {
            String curS = s + c;
            if (isHard(curS)) {
                list.add(curS);
                if (list.size() == count) {
                    System.out.println(list.toString());
                    System.exit(0);
                }
                dfs(l, curS);
            }
        }
    }

    /**
     * 判断是否是困难的串
     * 1.遍历所有的长度为偶数的子串，时间复杂度高
     * 2.curS - c已经是困难的串了
     * @param curS
     * @return
     */
    private static boolean isHard(String curS) {
        for (int i = curS.length() - 2, num = 1; i >= 0; i -= 2,num++) {
            if (curS.substring(i, i + num).equals(curS.substring(i + num)) ) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<String> list = new ArrayList<>();
}
