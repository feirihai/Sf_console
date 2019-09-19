package Z字形转换;
//
public class Solution {
    public static String convert(String s, int numRows){
        if (numRows ==1){
            return s;
        }
        boolean flag = false;
        int in = 0;
        int index = Math.min(s.length(),numRows);
        //定义每行字符串
        String []arg = new String[index];

        for(int i = 0; i< index; i++) arg[i] = "";
        //判断是向下还是向上，向下就+1，向上就-1
        for (int i = 0 ; i < s.length() ; i++){
            arg[in] += s.substring(i,i+1);
            if (in == 0 || in == numRows-1){
                flag = !flag;
            }
            in += flag ? 1:-1;
        }
        String ans = "";
        for(String row : arg) {
            ans += row;
        }
        return ans;
    }

}
