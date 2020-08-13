package 树结构;

public class 两个节点的公共祖先 {
    static Node result;


    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        Node x = 有序数组构建二叉搜索树.build(a, 0, a.length - 1);
        Node.printTree(x);
        Node target1 = new Node(4);
        Node target2 = new Node(5);
        ;
        System.out.println(getIt(x, target1, target2).value);
    }

    public static Node getIt(Node node, Node target1, Node target2) {
        if (node == null) {
            return null;
        }
        if (node.value == target1.value || node.value == target2.value) {
            return node;
        }
        boolean findTarget1 = find(node.left, target1);
        boolean findTarget2 = find(node.right, target2);
        if (findTarget1 == findTarget2) {
            return node;
        } else if (findTarget1) {
            return getIt(node.left,target1, target2);
        }else  {
            return getIt(node.right, target1, target2);
        }
    }
    private static boolean find(Node node, Node target) {
        if (node == null) {
            return false;
        } else if (node.value == target.value) {
            return true;
        }
        return find(node.left, target) || find(node.right, target);
    }
}
