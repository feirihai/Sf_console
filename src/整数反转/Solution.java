package 整数反转;

public class Solution {
    public static int reverse(int x){
        long temp=0;

        while(x!=0){
            //求位数
            int pop=x%10;
            temp=temp*10+pop;

            if(temp>Integer.MAX_VALUE||temp<Integer.MIN_VALUE){
                return 0;
            }
            //下一位
            x/=10;
        }
        return (int)temp;
    }

}
