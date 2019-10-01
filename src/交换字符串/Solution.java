package 交换字符串;

//两两交换
public class Solution {
     public static String getNew(String str){
         StringBuilder newStr = new StringBuilder(str);
         for (int i = 0 ; i < newStr.length() ; i++){
             if (Character.isLowerCase(newStr.charAt(i))){
                 while (i>0){
                     int flag= i-1;
                     if (Character.isUpperCase(newStr.charAt(flag))){
                         char a = newStr.charAt(i);
                         char b = newStr.charAt(flag);
                         newStr.setCharAt(i,b);
                         newStr.setCharAt(flag,a);
                     }else{
                         break;
                     }
                     i--;
                 }
             }
         }

         return newStr.toString();
     }
     public static String getNewStr(String str){

         return "";
     }

    public static void main(String[] args) {
        int a = 4;
        a = a--;
        int b = 5;
        b = a*b;
        a = a--;
        System.out.println(a);
        System.out.println(a+" "+b);
    }

}
