package 图结构;

/**
 * 得到8连通块的个数，上下左右还有斜对角方向
 * #代表连通区域，*代表隔离区域。
 */
public class 八连块 {
    static char[][] data = new char[][]{
            "*##**#".toCharArray(),
            "*#**#*".toCharArray(),
            "##**#*".toCharArray()
    };
    static int sum = 0;
    static boolean[][] isVisited = new boolean[data.length][data[0].length];
    public static void main(String[] args) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j]=='#' && !isVisited[i][j]) {
                    dfs(i, j);
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
    public static void dfs(int x, int y) {
        if( x < 0 || x >= data.length || y < 0 || y >= data[0].length
                ||data[x][y] == '*' || isVisited[x][y]){
            return;
        }
        isVisited[x][y] = true;
        dfs(x-1, y);
        dfs(x+1, y);
        dfs(x, y-1);
        dfs(x, y+1);
        dfs(x-1, y-1);
        dfs(x+1, y+1);
        dfs(x-1, y+1);
        dfs(x+1, y-1);
    }
}
