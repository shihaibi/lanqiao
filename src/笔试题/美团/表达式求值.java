package 笔试题.美团;

import java.util.Scanner;
import java.util.Stack;

public class 表达式求值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        Stack<String> stack = new Stack<>();
        boolean isG = false;
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek().equals("and")) {
                stack.pop();
                if (stack.size() > 0) {
                    String s1 = stack.pop();
                    if (checkTF(s1, arr[i])) {
                        if (s1.equals("true") && arr[i].equals("true")) {
                            stack.push("true");
                        } else
                            stack.push("false");

                    } else {
                        isG = true;
                        break;
                    }
                } else {
                    isG = true;
                    break;
                }
            }else
                stack.push(arr[i]);
        }
        boolean isOr = false;
        boolean res = false;
        while (!stack.isEmpty()) {
            if (isOr) {
                if (!stack.pop().equals("or")) {
                    isG = true;
                }
            } else {
                String s = null;
                if ((s = stack.peek()).equals("true") || s.equals("false"))
                    res = Boolean.parseBoolean(stack.pop()) || res;
                else
                    isG = true;
            }
            isOr = !isOr;
        }
        if (isG)
            System.out.println("error");
        else
            System.out.println(res);

    }
    public static boolean checkTF(String s1, String s2) {
        if ((s1.equals("true") || s1.equals("false") && (s2.equals("true") || s2.equals("false")))) {
            return true;
        } else {
            return false;
        }
    }
}
