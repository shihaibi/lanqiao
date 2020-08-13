package 树结构;

public class 判断平衡二叉树 {
    public static boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }
        if (isBalance(node.left) && isBalance(node.right)) {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            if (Math.abs(leftHeight - rightHeight) <= 1) {
                return true;
            }
        }
        return false;

    }
    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left != null) {
            return 1 + getHeight(node.left);
        } else if (node.right != null) {
            return 1 + getHeight(node.right);
        } else
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.right = new Node(7);
        Node.printTree(head);
        System.out.println(isBalance(head));


    }

}
