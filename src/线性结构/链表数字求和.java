package 线性结构;

public class 链表数字求和 {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(6);
        Node e = new Node(9);
        a.next = b;
        c.next = d;
        System.out.println(getSum(a,c));

    }
    public static Node getSum(Node a, Node b) {
        Node head = new Node(0);
        Node pHead = head;
        boolean isJin = false;
        while (a != null && b != null) {
            head.next = new Node(0);
            head = head.next;
            if (isJin) {
                head.value = a.value + b.value +1;
            } else {
                head.value = a.value + b.value;
            }
            if ((head.value)/10 == 1) {
                head.value = head.value%10;
                isJin = true;
            }
            a = a.next;
            b = b.next;

        }
        if (a != null) {
            head.next = a;
        } else if (b != null) {
            head.next = b;

        }
        while (head.next!= null) {
            head = head.next;
            if (isJin) {
                head.value = head.value +1;
                isJin = false;
            }

            if (head.value / 10 == 1) {
                head.value = head.value%10;
                isJin = true;
            }

        }
        if (isJin) {
            head.next = new Node(1);
        }


        return pHead.next;
    }
}
