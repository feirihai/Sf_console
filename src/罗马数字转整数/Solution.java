package 罗马数字转整数;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int sum = 0;
        for (int i = 0 ; i < s.length()-1 ; i++){
            String a = s.charAt(i)+"";
            if (map.containsKey(a)){
                if (s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                    sum = sum + (-1)*map.get(a);
                }
                else if (s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                    sum = sum + (-1)*map.get(a);
                }
                else if (s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                    sum = sum + (-1)*map.get(a);
                }else
                sum = sum + map.get(a);
            }

        }
        String b = s.charAt(s.length()-1)+"";
        sum = sum + map.get(b);
        return sum;
    }

    public static void main(String[] args) {
        int  a = romanToInt("MCMXCIV");
        System.out.println(a);
    }
}
