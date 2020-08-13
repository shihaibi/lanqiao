package 线性结构;

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String next = this.next == null ? "null":this.next.toString();
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }


}
public class 链表中的倒数第k个节点 {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;
        System.out.println(getLastK(a, 1));
        System.out.println(getLastK(a, 2));
        System.out.println(getLastK(a, 3));
        System.out.println(getLastK(a, 4));
    }
    public static int getLastK(Node head, int k) {
        if (head == null || k <= 0)
            return -1;
        Node cur = head;
        while (cur!= null && k > 0) {
            cur = cur.next;
            k--;
        }
        if (k != 0) {
            return -1;
        }
        while (cur != null) {
            head = head.next;
            cur = cur.next;
        }
        return head.value;
    }

}

