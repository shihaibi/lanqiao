package 树结构;

import java.util.Stack;

public class 非递归遍历 {
    public static void 先序遍历(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.value);
            if (cur.rightNode != null) {
                stack.push(cur.rightNode);
            }
            if (cur.leftNode != null) {
                stack.push(cur.leftNode);
            }
        }
    }
    public static void 中序遍历(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || treeNode != null) {
            if (treeNode == null) {
                treeNode = stack.pop();
                System.out.println(treeNode.value);
                treeNode = treeNode.rightNode;
            } else{
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
        }
    }
    public static void 后序遍历1(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            stack1.push(cur);
            if (cur.leftNode != null) {
                stack.push(cur.leftNode);
            }
            if (cur.rightNode != null) {
                stack.push(cur.rightNode);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop().value);
        }
    }
    public static void 后序遍历2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        TreeNode lastNode = treeNode;
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek();
            if (curNode.leftNode != null && lastNode != curNode.leftNode
            && lastNode != curNode.rightNode) {
                stack.push(curNode.leftNode);
            } else if (curNode.rightNode != null && lastNode != curNode.rightNode) {
                stack.push(curNode.rightNode);
            } else {
                stack.pop();
                System.out.println(curNode.value);
                lastNode = curNode;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(3,a,b);
        TreeNode<Integer> d = new TreeNode<>(4,null, null);
        TreeNode<Integer> e = new TreeNode<>(5,c,d);
        后序遍历2(e);
    }

}
