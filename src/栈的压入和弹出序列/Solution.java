package 栈的压入和弹出序列;
import java.util.Stack;

public class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        //标识弹出层位置即popA的位置
        int index = 0;

        for (int i = 0 ; i < pushA.length ; i++){
            stack.push(pushA[i]);

            //如果栈头与popA头不相同就入栈
            while(!stack.empty()&&stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int []a = new int[]{1,2,3,4,5};
        int []b = new int[]{2,1,5,4,3};
        Boolean s = IsPopOrder(a,b);
        System.out.println(s);
    }
}
