package 不用加减乘除做加法;

import java.util.Map;

public class Solution {

    public static int Add(int num1,int num2) {
        int count = 0;
        for (int i = 0 ; i < Math.abs(num1) ; i++){
            if (num1>0){
                count++;
            }else {
                count--;
            }
        }
        for (int i = 0 ; i < Math.abs(num2) ; i++){
            if (num2>0){
                count++;
            }else {
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = Add(1,6);
        System.out.println(a);
    }
}
