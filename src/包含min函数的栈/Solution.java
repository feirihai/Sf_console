package 包含min函数的栈;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        while (stack.empty()!=true){
            int flag = stack.peek();
            stack.pop();
            if (flag < min){
                min = flag;
            }
            stack2.push(flag);
        }
        while (stack2.empty()!=true){
            stack.push(stack2.pop());
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(3);
        System.out.println(solution.min());
        solution.push(4);
        System.out.println(solution.min());
        solution.push(2);
        System.out.println(solution.min());
        solution.push(3);
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.push(0);
        System.out.println(solution.min());
    }
}
