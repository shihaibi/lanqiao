package 笔试题.广联达;

public class 链表的中间节点 {
    public static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node findIt(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        a.next.next.next.next = new Node(5);
        a.next.next.next.next.next = new Node(6);
        Node b = findIt(a);
        System.out.println(b.val);
    }
}
