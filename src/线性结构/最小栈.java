package 线性结构;

import java.util.Stack;

/**
 * 设计一个栈，能始终调用min方法返回栈中的最小元素
 */
public class 最小栈 {
    public static void main(String[] args) {
        minStack min = new minStack();
        min.push(5);
        min.push(2);
        min.min();
        min.pop();
        min.pop();
        min.min();
    }
    public static class minStack{
        int curMin;
        Stack<Integer> num ;
        Stack<Integer> min ;
        public minStack() {
            this.curMin = Integer.MAX_VALUE;
            this.num = new Stack<>();
            this.min = new Stack<>();
        }



        public void push(int i) {
            num.push(i);
            if (i < this.curMin) {
                curMin = i;
            }
            min.push(curMin);
        }
        public int pop() {
            try {
                min.pop();
                return num.pop();
            }catch (Exception e) {
                System.out.println("没有东西了");
            }
            return -1;
        }
        public void min() {
            try{
                System.out.println(min.peek());
            }catch (Exception e) {
                System.out.println("什么都看不到");
            }

        }
    }
}
