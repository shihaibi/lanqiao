package 线性结构;

import java.util.Stack;

/**
 * 方法1，翻转链表
 * 方法2，快慢指针
 */
public class 检查链表中回文 {
    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(3);
        a.next.next.next.next = new Node(3);
        a.next.next.next.next.next = new Node(1);
        System.out.println(isHuiwen(a));

    }
    public static boolean isHuiwen(Node head){
        Node fast = head;
        Node slow = head;
        boolean isOdd = false;
        Stack<Node> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow);
            slow = slow.next;
            if (fast == null) {
                isOdd = true;
            }
        }
        /*
        0 1 2 3
        fast slow
        2       1
        null    2
         */
        if (!isOdd) {
            slow = slow.next;
        }
        while (!stack.empty()) {
            if (stack.pop().value == slow.value) {
                slow = slow.next;
            } else
                return false;
        }
        return true;
    }
}
