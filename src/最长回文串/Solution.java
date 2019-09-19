package 最长回文串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String longestPalindrome(String s){
        String middle="";
        boolean g = true;
        Map map = new HashMap();
        int k = 0;
        if (s.equals("") ){
            return "";
        }
        if (s.length()==1){
            return s;
        }
        for (int i = 0 ; i < s.length() ; i++) {
            char flag = s.charAt(i);
            int index = s.lastIndexOf(flag);
            if (index == i) {
                map.put(1,s.substring(i,i+1));
                k = Math.max(1,k);
                continue;
            } else {
                middle = s.substring(i, index+1);
            }
            for (int j = 0; j < middle.length() / 2; j++) {
                if (middle.charAt(j) != middle.charAt(middle.length() - 1 - j)) {
                    middle = middle.substring(0, middle.length() - 1);
                    int l = middle.lastIndexOf(middle.charAt(0));
                    middle = middle.substring(0,l+1);
                    if (l == 0) {
                        g = false;
                        break;
                    }else{
                        g = true;
                        j = -1;
                    }
                }else {
                    g = true;
                }
            }
            if (g){
                map.put(middle.length(),middle);
                k = Math.max(middle.length(),k);
            }

        }
        return (String) map.get(k);
    }
}
