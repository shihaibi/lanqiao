package 递归和深度优先搜索;


import java.util.Scanner;



public class 部分和 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        boolean[] isGet = new boolean[num];
        getAnswer(arr,isGet, k, 0, 0);
        System.out.println("NO");
    }

    private static void getAnswer(int[] arr,boolean[] isGet, int k, int index, int curSum) {
        if (curSum == k) {
            print(arr, isGet, k);
            System.exit(0);
        } else if (curSum > k || index == arr.length) {
            return;
        }
        isGet[index] = true;
        getAnswer(arr, isGet, k,index + 1, curSum + arr[index]);
        isGet[index] = false;
        getAnswer(arr, isGet, k,index + 1, curSum);
    }

    private static void print(int[] arr, boolean[] isGet, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("YES ").append(k).append(" = ");
        for (int i = 0; i < isGet.length; i++) {
            if (isGet[i]) {
                sb.append(arr[i]).append(" + ");
            }
        }
        String str = sb.toString();
        System.out.println(str.substring(0, str.length()-2));
    }
}
