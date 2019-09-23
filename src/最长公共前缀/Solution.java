package 最长公共前缀;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        List list = Arrays.asList(strs);
        if (list.contains("")){
            return "";
        }
        int flag = 1000000000;
        int index = 0;
        for (int i = 0 ; i < strs.length ; i++){
            if (strs[i].length()<=flag){
                flag = strs[i].length();
                index = i;
            }
        }
        boolean a = true;
        String  b = "";
        for (int i = 0 ; i <strs[index].length() ; i++){
            for (int h = 0 ; h < strs.length ; h++){
                if (h == index){
                    continue;
                }
                if (strs[index].charAt(i)==strs[h].charAt(i)){
                    a = true;
                }else
                {
                    a = false;
                    break;
                }
            }
            if (a == true){
                b = b + strs[index].charAt(i);
            }else {
                return b;
            }

        }
        return b;
    }

    public static void main(String[] args) {
        String a[] = {"c","acc","ccc"};
        String b = longestCommonPrefix(a);
        System.out.println(b);
    }
}
