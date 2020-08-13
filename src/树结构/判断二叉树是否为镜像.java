package 树结构;

public class 判断二叉树是否为镜像 {
    public static boolean 镜像(TreeNode treeNode1, TreeNode treeNode2){
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }else if(treeNode1 == null || treeNode2 == null) {
            return false;
        } else if (treeNode1.value == treeNode2.value) {
            return 镜像(treeNode1.leftNode,treeNode2.rightNode)&&
                    镜像(treeNode1.rightNode,treeNode2.leftNode);
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(3,a,b);
        TreeNode<Integer> g = new TreeNode<>(3,b,a);
        TreeNode<Integer> d = new TreeNode<>(4,null, null);
        TreeNode<Integer> e = new TreeNode<>(5,c,d);
        TreeNode<Integer> f = new TreeNode<>(5,d,null);
        System.out.println(镜像(e, f));

    }
}
