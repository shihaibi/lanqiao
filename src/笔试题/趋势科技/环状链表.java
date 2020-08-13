package 笔试题.趋势科技;

import java.util.Scanner;

public class 环状链表 {
    static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }

        Node next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getN(n));
    }
    public static int getN(int n) {
        if (n < 2) {
            return n;
        }
        Node head = new Node(1);
        Node headtmp = head;
        for (int i = 2; i <= n ; i++) {
            head.next = new Node(i);
            head = head.next;
        }
        head.next = headtmp;
        head = headtmp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i; j++) {
                head = head.next;
            }
            head.next = head.next.next;
            head = head.next;
        }
        return head.val;

    }
}
