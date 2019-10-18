package 字母异位词分组;

import java.util.*;
//先把key按顺序排出来，在进行添加
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0||strs==null){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0 ; i < strs.length ; i++){
            char []a = strs[i].toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
                map.get(key).add(strs[i]);
            }else {
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
