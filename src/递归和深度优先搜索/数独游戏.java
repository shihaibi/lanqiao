package 递归和深度优先搜索;

import java.util.Arrays;

public class 数独游戏 {
    public static void main(String[] args) {
        String[] arr = new String[]{
                "005300000",
                "800000020",
                "070010500",
                "400005300",
                "010070006",
                "003200080",
                "060500009",
                "004000030",
                "000009700"
        };
        char[][] table = new char[9][];
        for (int i = 0; i < 9; i++) {
            table[i] = arr[i].toCharArray();
        }
        dfs(table, 0, 0);

    }

    private static void dfs(char[][] table, int a, int b) {
        if (a == 9) {
            for (char[] arr : table)
                System.out.println(Arrays.toString(arr));
            System.exit(0);
        }
        if (table[a][b] != '0') {
            dfs(table, a + (b + 1)/9, (b + 1)%9);
        } else {
            for (int i = 1; i < 10; i++) {
                if (check(table, a, b, i)) {
                    table[a][b] = (char)('0' + i);
                    dfs(table, a + (b + 1)/9, (b + 1)%9);
                }
            }
            table[a][b] = '0';
        }
    }

    private static boolean check(char[][] table, int a, int b, int i) {
        char c = (char)('0' + i);
        for (int j = 0; j < 9; j++) {
            if (table[a][j] == c || table[j][b] == c) return false;
        }
        for (int j = a/3*3 ; j < (a/3 + 1) * 3; j++) {
            for (int k = b/3*3 ; k < (b/3 + 1) * 3; k++) {
                if (table[j][k] == c) return false;
            }
        }
        return true;
    }
}
