package 线性结构;

/**
 * 按照数字k分割链表。小于k的放左边，大于等于k的放右边
 * 同时不能改变相对位置。
 */
public class 分割链表 {
    public Node partition(Node head, int x) {
        Node leftHead = null;
        Node leftTail = null;
        Node rightHead = null;
        Node rightTail = null;
        while (head != null) {
            if (head.value < x) {
                if (leftHead == null) {
                    leftHead = head;
                    leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            }
            head = head.next;
        }
        if (rightTail != null) {
            rightTail.next = null;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;


    }
}
