package 树结构;

import java.util.Stack;

public class 根到叶子的路径和 {
    /**
     * 递归解法
     * @param value
     * @param node
     * @return
     */
    public static int sum(int value, Node node) {
        if (node == null) {
            return 0;
        }
        value = value *10 + node.value;
        if (node.left == null && node.right == null) {
            return value;
        }
        return sum(value, node.left) +sum(value, node.right);

    }

    /**
     * 非递归解法
     */
    public static int sum2(Node node) {
        Stack<Node> stack = new Stack<>();
        //.push(node);
        int sum = 0;
        int curSum = 0;
        stack.push(node);
        Node lastNode = node;
        while (!stack.isEmpty()) {
            Node curNode = stack.peek();
            if (curNode.left != null && lastNode != curNode.left
                    && lastNode != curNode.right) {
                stack.push(curNode.left);
            } else if (curNode.right != null && lastNode != curNode.right) {
                stack.push(curNode.right);
            } else {
                stack.pop();
                System.out.println(curNode.value);
                lastNode = curNode;
            }
        }
return sum;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        System.out.println(sum(0, head));
        System.out.println(sum2( head));
    }
}
