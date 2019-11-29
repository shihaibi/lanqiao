package 递归和深度优先搜索;
/**
 * 1.递归
 * 2.迭代
 * 3.回溯
 */

import java.util.ArrayList;
import java.util.List;

public class 字符全排列  {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(getAllList1(str,str.length() - 1));
        System.out.println(getAllList2(str));
        getAllList3(str.toCharArray(),0);
        System.out.println(list);

    }
    public static List<String> getAllList1(String str, int index) {
        List<String> list = new ArrayList<>();
        if (index == 0) {
            list.add(String.valueOf(str.charAt(0)));
            return list;
        }
        List<String> preList = getAllList1(str, index - 1);
        char c = str.charAt(index);
        for (String s : preList) {
            for (int i = 0; i <= index; i++) {
                list.add(s.substring(0,i) + c + s.substring(i));
            }
        }
        return list;
    }
    public static List<String> getAllList2(String str) {
        List<String> list = new ArrayList<>();

        list.add(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            List<String> curList = new ArrayList<>();
            char c = str.charAt(i);
            for (String s : list) {
                for (int j = 0; j <= i; j++) {
                    curList.add(s.substring(0,j) + c + s.substring(j));
                }
            }
            list = curList;
        }
        return list;
    }

    static List<String> list = new ArrayList<>();
    public static void getAllList3(char[] arr, int index) {
        if (index == arr.length) {
            list.add(new String(arr));
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            getAllList3(arr, index + 1);
            swap(arr, i, index);
        }
    }
    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
