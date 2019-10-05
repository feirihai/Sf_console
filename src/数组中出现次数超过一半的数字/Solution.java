package 数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int max = 0;
        int index = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < array.length ; i++){
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                int a = map.get(array[i]);
                a = a + 1;
                map.put(array[i],a);
            }
            if (map.get(array[i]) > max){
                max = map.get(array[i]);
                index = array[i];
            }
        }
        if (max > array.length/2){
            return index;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int []a =new int[]{1,2,3,2,2,2,5,4,2};
        int as = MoreThanHalfNum_Solution(a);
        System.out.println(as);
    }
}
