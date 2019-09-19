package 两数之和;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        //返回两个数
        int []num = new int[2];
        int x;
        //将数组保存在map中
        for (int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],i);
        }
        for (int j = 0 ; j < nums.length ; j++){
            //取出数组中第一个数
            x = nums[j];
            //判断map是否含有 和 - 第一个数（即另一个加数且这个加数不是当前数）
            if (map.containsKey(target-nums[j]) && map.get(target-nums[j])!=j){
                num[0] = j;
                num[1] = map.get(target-nums[j]);
                break;
            }
        }
        return  num;
    }
}
