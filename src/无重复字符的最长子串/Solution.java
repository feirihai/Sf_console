package 无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int  lengthOfLongestSubstring(String s){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int right = 0;
        int max = 0;
        //将字符串保存在map，每一次都计算最长
        for (int i = 0 ; i < s.length() ; i++){
            if (map.containsKey(s.charAt(i))){
                //取重复位置
                right = Math.max(right,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-right+1);
        }

        return max;
    }

    public static void main(String[] args) {
        String a = "abcdba";
        lengthOfLongestSubstring(a);
    }
}
