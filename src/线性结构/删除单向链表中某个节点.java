package 线性结构;

public class 删除单向链表中某个节点 {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;
        deleteNode(a);
        System.out.println(a);
    }
    public static boolean deleteNode(Node node) {
        if (node.next == null) {
            return false;
        }
        node.value = node.next.value;
        node.next = node.next.next;
        return true;
    }
}
