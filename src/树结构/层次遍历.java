package 树结构;

import java.util.LinkedList;
import java.util.Queue;

public class 层次遍历 {
    public static void cengciPrint(TreeNode<Integer> node) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(node);
        TreeNode<Integer> line = node;
        TreeNode<Integer> nextLine = null;
        int count = 0;//层数
        while (!queue.isEmpty()) {
            TreeNode<Integer> curNode = queue.poll();
            System.out.println(curNode.value);
            if (curNode.leftNode != null) {
                queue.add(curNode.leftNode);
                nextLine = curNode.leftNode;
            }
            if (curNode.rightNode != null) {
                queue.add(curNode.rightNode);
                nextLine = curNode.leftNode;
            }
            if (curNode == line) {
                line = nextLine;
                count++;
            }

        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(3,a,b);
        TreeNode<Integer> d = new TreeNode<>(4,null, null);
        TreeNode<Integer> e = new TreeNode<>(5,c,d);
        cengciPrint(e);

    }
}
