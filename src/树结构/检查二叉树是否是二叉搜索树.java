package 树结构;

import java.util.*;

/**
 * 可以用中序遍历的方式
 * 1.记录中序遍历的值用list存储
 * 2.全局变量保证中序遍历递增。
 */
public class 检查二叉树是否是二叉搜索树 {
    public static boolean check(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if(node.value < max && node.value > min) {
            return check(node.left, min, node.value)
                    &&check(node.right, node.value, max);
        }
        return false;
    }

}
