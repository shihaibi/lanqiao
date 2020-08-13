package 树结构;

/**
 * 要求二叉搜索树的高度最低
 */
public class 有序数组构建二叉搜索树 {
    public static Node build (int[] arr, int start, int end){
        if (start>end || start < 0 || end >= arr.length) {
            return null;
        }
        int mid = start + (end - start)/2;
        Node node = new Node(arr[mid]);
        node.left = build(arr, start, mid - 1);
        node.right = build(arr, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8};
        Node x = build(a, 0, a.length - 1);
        Node.printTree(x);
    }
}
