package 两个栈实现队列;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int n = stack1.size();
        for (int i = 0 ; i < n-1 ; i++){
            stack2.push(stack1.pop());
        }
        int a = stack1.pop();
        int b = stack2.size();
        for (int i = 0; i < b ; i++){
            stack1.push(stack2.pop());
        }
        return a;
    }
    /*
    *
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    * */

    public static void main(String[] args) {
        Solution a = new Solution();
        a.push(1);
        a.push(2);
        a.push(3);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(4);
        System.out.println(a.pop());
        a.push(5);
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}