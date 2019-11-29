package 数学问题;

public class 阶梯Nim问题 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{2,3,4},{1,2,4,5}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(get(arr[i]));
        }
    }

    private static String get(int[] arr) {
        int res = 0;
        if ((arr.length & 1) == 0) {
            for (int i = 0; i < arr.length; i+= 2) {
                res ^= arr[i + 1] - arr[i] - 1;
            }
        } else {
            res ^= arr[0] - 1;
            for (int i = 1; i < arr.length; i +=2) {
                res ^= arr[i + 1] - arr[i] - 1;
            }
        }
        return res == 1 ? "先手赢" : "后手赢";
    }
}
