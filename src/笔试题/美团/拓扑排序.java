package 笔试题.美团;

import java.util.*;

public class 拓扑排序 {
    private static int[][] graph = new int[26][26];

    private static int[] indegree = new int[26];

    private static boolean[] flag = new boolean[26];
    private static Set<Character> set = new HashSet<>();
    private static List<Character> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        build(input);
        topology();
    }

    private static void topology() {
        boolean isValid = false;
        int len = set.size();
        for (int i = 0; i < len; i++) {
            Character curChar = null;
            int count = 0;
            for (char c : set) {
                if (indegree[c - 'a'] != 0) {
                    continue;
                }
                curChar = c;
                count++;
            }

            if (count != 1) {
                isValid = true;
                break;
            } else {
                ans.add(curChar);
                for (int j = 0; j < graph[0].length; j++) {
                    if (graph[curChar - 'a'][j] != 0) {
                        indegree[j] -= graph[curChar - 'a'][j];
                    }
                }
            }
            set.remove(curChar);


        }
        if (isValid) {
            System.out.println("invalid");
        }else  {
            for (char c: ans) {
                System.out.print(c);
            }
        }
    }

    private static void build(String[] input) {
        for (char c: input[0].toCharArray()) {
            set.add(c);
        }
        for (int i = 1; i < input.length; i++) {
            String preStr = input[i - 1];
            String curStr = input[i];
            for (char c: input[i].toCharArray()) {
                set.add(c);
            }
            int j = 0;
            int len = Math.min(preStr.length(), curStr.length());
            while (j < len &&  preStr.charAt(j) == curStr.charAt(j)) {
                j++;
            }
            if (preStr.charAt(j) == curStr.charAt(j))   continue;
            indegree[curStr.charAt(j) - 'a']++;
            graph[preStr.charAt(j)- 'a'][curStr.charAt(j) - 'a']++;
            flag[preStr.charAt(j)- 'a'] = true;
            flag[curStr.charAt(j)- 'a'] = true;

        }
    }

}
