package 树结构;

import java.util.*;

public class 二叉树节点路径 {
    public static List<Node> findWay(Node node, Node target) {

        Stack<Node> stack = new Stack<>();
        HashMap<Node, List<Node>> hashMap = new HashMap<>();
        stack.push(node);
        Node curNode = node;
        List<Node> list = new ArrayList<>();
        list.add(node);
        hashMap.put(curNode, list);
        while(!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode.value == target.value) {
                return hashMap.get(curNode);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
                List<Node> cloneList = (List<Node>) ((ArrayList<Node>) (hashMap.get(curNode))).clone();
                cloneList.add(curNode.right);
                hashMap.put(curNode.right, cloneList);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
                List<Node> cloneList = (List<Node>) ((ArrayList<Node>) (hashMap.get(curNode))).clone();
                cloneList.add(curNode.left);
                hashMap.put(curNode.left, cloneList);
            }
        }

        return new ArrayList<>();
    }
    public static void findWay2(Node node, Node target, List<Node> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        if (node.value == target.value) {
            for(Node x:list) {
                System.out.println(x.value);
            }
        }
        findWay2(node.left, target, list);
        findWay2(node.right, target, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,5,6,7,8};
        Node x = 有序数组构建二叉搜索树.build(a, 0, a.length - 1);
        Node.printTree(x);
        //List<Node> b = findWay(x, new Node(6));
//        for (Node node:b) {
//            System.out.println(node.value);
//        }
         findWay2(x, new Node(6), new ArrayList<>());

    }
}
