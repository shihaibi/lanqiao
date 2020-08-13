package 笔试题.美团;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 美团骑手包裹区间分组 {
    static class Union {
        int start;
        int end;

        public Union(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Union> map = new HashMap<>();
        ArrayList<Union> oldList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).end = i;
            } else {
                Union union = new Union(i, i);
                map.put(c, union);
                oldList.add(union);
            }
        }
        ArrayList<Union> curList = new ArrayList<>();
        curList.add(oldList.get(0));
        for (int i = 1; i < oldList.size(); i++) {
            Union curUnion = curList.get(curList.size() - 1);
            Union oldUnion = oldList.get(i);
            if (oldUnion.start > curUnion.end) {
                curList.add(oldUnion);
            } else {
                curUnion.end = Math.max(curUnion.end, oldUnion.end);
            }
        }
        Union temp = null;
        for (int i = 0; i < curList.size(); i++) {
            System.out.print((curList.get(i).end - curList.get(i).start + 1) + " ");
        }

        System.out.println();
    }
}
