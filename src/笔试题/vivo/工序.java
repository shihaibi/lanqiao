package 笔试题.vivo;

import java.util.*;

public class 工序 {
    static int[][] arr;
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        int n = 0;
        try {
            scanner = new Scanner(System.in);
            n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                lines.add(scanner.nextLine());
            }
                // write your code here


        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
         arr = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] str = lines.get(i).split(" ");
            arr[i] = new int[str.length];
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.valueOf(str[j]);
            }
        }

        // TODO output
        ListNode head = mergeNodes(null);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

    static class Union{
        int val;
        int seq;
        public Union(int val, int seq) {
            this.val = val;
            this.seq = seq;
        }
    }
    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static ListNode mergeNodes(ListNode head ) {
        PriorityQueue<Union> priorityQueue = new PriorityQueue<>(new Comparator<Union>() {
            @Override
            public int compare(Union o1, Union o2) {
                return o1.val - o2.val;
            }
        });
        // write your code here
        int[] index = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Union(arr[i][0], i));
            index[i]++;
        }

        ListNode dummy = new ListNode(0);
        head = dummy;
        while (!priorityQueue.isEmpty()) {
            Union u1 = priorityQueue.poll();
            int i = u1.seq;
            if (index[i] < arr[i].length) {
                priorityQueue.add(new Union(arr[i][index[i]], i));
                index[i]++;
            }
            head.next = new ListNode(u1.val);
            head = head.next;

        }
        return dummy.next;
    }


}
