package 递归和深度优先搜索;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.递归法
 * 2.迭代法
 * 3.二进制法
 */
public class 子集生成 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        HashSet<HashSet<Integer>> newSet = getSubsets(arr, arr.length - 1);
        newSet.remove(new HashSet<>());
        System.out.println(newSet );
        Set<Set<Integer>> newSet1 = getSubSets1(arr);
        newSet1.remove(new HashSet<>());
        System.out.println(newSet1);
        Set<Set<Integer>> newSet2 = getSubSets2(arr);
        System.out.println(newSet2);
    }
    private static HashSet<HashSet<Integer>> getSubsets(int[] arr, int cur) {
        HashSet<HashSet<Integer>> newSet = new HashSet<>();
        if (cur == -1) {
            newSet.add(new HashSet<>());
            return newSet;
        }
        HashSet<HashSet<Integer>> set = getSubsets(arr, cur - 1);
        for (HashSet<Integer> curSet : set) {
            newSet.add(curSet);
            HashSet<Integer> clone = (HashSet<Integer>) curSet.clone();
            clone.add(arr[cur]);
            newSet.add(clone);
        }
        return newSet;
    }
    private static Set<Set<Integer>> getSubSets1(int[] arr) {
        Set<Set<Integer>> res = new HashSet<>();
        res.add(new HashSet<>());
        for (int i = 0; i < arr.length; i++) {
            Set<Set<Integer>> res_new = new HashSet<>();
            res_new.addAll(res);
            for (Set<Integer> cur : res) {
                Set<Integer> clone = (Set<Integer>) ((HashSet) cur).clone();
                clone.add(arr[i]);
                res_new.add(clone);
            }
            res = res_new;
        }
        return res;
    }
    private static Set<Set<Integer>> getSubSets2(int[] arr) {
        //如果要用字典序
        Set<Set<Integer>> res = new HashSet<>();
        for (int i = 1; i < Math.pow(2, arr.length);i++) {
            Set<Integer> cur = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                if (((i>>j)&1) == 1) {
                    cur.add(arr[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }
}
