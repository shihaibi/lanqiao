package 数组;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,3,5,7,5,8,6};
        MinHeap m = new MinHeap();
        m.buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            m.swap(arr, 0, i);
            m.modify(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));

    }
}
class MinHeap{
    public void buildHeap(int[] arr) {
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            modify(arr, i, arr.length);
        }

    }
    public void modify(int[] arr, int index, int length) {
        int temp = arr[index];
        for (int i = index * 2 + 1; i < length; i = index * 2 + 1) {
            if (i + 1 < length && arr[i + 1] > arr[i]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[index] = arr[i];
                index = i;
            } else break;
        }
        arr[index] = temp;

    }
    public void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
