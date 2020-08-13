package 树结构;

public class 二叉树的最小深度 {
    public static int minDepth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int leftDepth = minDepth(node.left);
        int rightDepth = minDepth(node.right);
        if (node.left == null) {
            return 1 + rightDepth;
        }
        if (node.right == null) {
            return 1 + leftDepth;
        }
        return 1 + Math.min(leftDepth, rightDepth);

    }
}
