package 递归和深度优先搜索;

public class 水洼数目 {
    public static void main(String[] args) {
        String[] strs = {
                "w........ww.",
                ".www.....www",
                "....ww...ww.",
                ".........ww.",
                ".........w..",
                "..w......w..",
                ".w.w......w.",
                "w.w.w..w..ww",
                ".w.w.......w",
                "..w....w..ww"
        };
        char[][] arr = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = strs[i].toCharArray();
        }
        get(arr);
    }
    private static void get(char[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'w') {
                    dfs(arr, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(char[][] arr, int i, int j) {
        if (i == -1 || i == arr.length || j == -1 || j == arr[0].length) {
            return;
        }
        if (arr[i][j] == '.') return;
        arr[i][j] = '.';
        for (int k = i-1; k < i + 2; k++) {
            for (int m = j-1; m < j + 2; m++) {
                if (k == i && m == j) continue;
                dfs(arr, k, m);
            }
        }
    }
}
