package 树结构;

public class 翻转二叉树 {
    public static void 翻转(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            翻转(node.left);
        }
        if (node.right != null) {
            翻转(node.right);
        }
        Node curNode = node.left;
        node.left = node.right;
        node.right = curNode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        Node.printTree(head);
        翻转(head);
        System.out.println();
        Node.printTree(head);
    }

}
