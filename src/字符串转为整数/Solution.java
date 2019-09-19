package 字符串转为整数;

public class Solution {
    public static int myAtoi(String str) {
        int c = 0;
        String end = "";
        String new_str = str.trim();
        if (new_str.equals("")||new_str.equals("-")||new_str.equals("+")){
            return 0;
        }
        String flag = "";
        if (new_str.charAt(0)>='0'&&new_str.charAt(0)<='9'||new_str.charAt(0)=='-'||new_str.charAt(0)=='+'){
            flag = new_str.substring(0,1);
            for (int i = 1 ; i < new_str.length() ; i++){
                if (new_str.charAt(i)>='0'&&new_str.charAt(i)<='9'){
                    flag += new_str.substring(i,i+1);
                }else{
                    break;
                }
                if (new_str.charAt(0)=='-'&&(new_str.charAt(1)>'9'||new_str.charAt(1)<'0')||new_str.charAt(0)=='+'&&(new_str.charAt(1)>'9'||new_str.charAt(1)<'0')){
                    return 0;
                }
                if (new_str.charAt(1)>'9'||new_str.charAt(1)<'0'){
                    break;
                }
            }
            String x = flag;
            int index = 0;
            if (x.charAt(0)=='-'||x.charAt(0)=='+'){
                x = x.substring(1);
            }
            boolean l = false;
            for (int i = 0 ; i < x.length() ; i++){
                if (x.charAt(i)>'0'){
                    l = true;
                    index = i;
                    break;
                }
            }
            if (index == 0&&l==false){
                return 0;
            }else{
                String v = "";
                if (flag.charAt(0)=='+'||flag.charAt(0)=='-'){
                    v = flag.substring(0,1);
                    end = v + x.substring(index);
                }else {
                    end = x.substring(index);
                }
            }
            String io = Integer.MAX_VALUE+"";
            if (end.contains("-")||end.contains("+")){
                if (end.length()-1>io.length()){
                    if (end.contains("-"))
                        return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
            }else {
                if (end.length()>io.length()){
                    return Integer.MAX_VALUE;
                }
            }

            long p = Long.parseLong(end);
            if (p>Integer.MAX_VALUE||p<Integer.MIN_VALUE){
                if (p>0){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }

            }else {
                return (int)p;
            }
        }else {
            return 0;
        }
    }
/*
    * 此题解用到了64位环境变量，面试官如果未要求环境变量，这种题解是一种不错的解法，可以借鉴来看一下。
1.首先去除字符串左右空格,不符合条件的直接return 0;
2.sign是符号位,start指针指向第一个数字的位置,如果第一位为数字,则sign=1,start=0,否则firstChar接收字符串第一个字符,若为“+”、“-”,sign分别赋值1、-1,start自增1,
3.从字符串第一个为数字的位置开始遍历,res为无符号结果,如果res大于Integer最大值且sign=1,输出Integer的最大值,反之输出Integer最小值,如果遍历到不为数字的字符,则直接返回res*sign;
4.如果遍历时该字符串未超范围,且无非数字字符,则返回res * sign;
5.完结。
*/
    public int myAtoii(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;

        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
