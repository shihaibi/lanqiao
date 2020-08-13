package 数组;

import java.util.Arrays;

public class 快速排序 {
    public static void main(String[] args) {
        int[] a = new int[]{5,10,2,100,223,44, 3,2 , 4, 1, 6, 9, 8};
        sort2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    //没有把partition和sort分开
    private static void sort(int[] arr, int s1, int e1) {
        if (s1 < e1){
            int start = s1;
            int end = e1;
            int mark = arr[start];
            int index = start;
            while (start < end) {
                while (start < end && arr[end] > mark) {
                    end--;
                }
                arr[start] = arr[end];

                while (start < end && arr[start] <= mark) {
                    start++;
                }
                arr[end] = arr[start];
            }
            arr[start] = mark;
            sort(arr, s1, start - 1);
            sort(arr, end + 1, e1);
        }


    }
    //分开版
    private static void sort2(int[] arr, int s1, int e1) {
        if (s1 < e1) {
            int pic = partition(arr, s1, e1);
            sort2(arr, s1, pic - 1);
            sort2(arr, pic + 1, e1);
        }

    }
    private static int partition ( int[] arr, int start, int end){
        int mark = arr[start];
        while (start < end) {
            while (start < end && arr[end] > mark) {
                end--;
            }
            arr[start] = arr[end];

            while (start < end && arr[start] <= mark) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = mark;
        return start;
    }

}

