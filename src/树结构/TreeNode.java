package 树结构;



public class TreeNode <E>{
    public E value;
    public TreeNode<E> leftNode;
    public TreeNode<E> rightNode;

    public TreeNode() {
    }

    public TreeNode(E value) {
        this.value = value;
    }

    public TreeNode(E value, TreeNode<E> leftNode, TreeNode<E> rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

}
