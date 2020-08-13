package 线性结构;

import java.util.Stack;

/**
 * 按照升序进行排序，最多使用一个辅助的栈
 */
public class 栈排序 {
    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> target = new Stack<>();
        while (!stack.isEmpty()) {
            int i = stack.pop();
            int count = 0;
            while (!target.isEmpty() && i > target.peek()) {
                stack.push(target.pop());
                count++;
            }
            target.push(i);
            for (int j = 0; j < count; j++) {
                target.push(stack.pop());
            }
        }
        return target;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack = sort(stack);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
