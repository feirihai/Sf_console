package 全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> group = new ArrayList<List<Integer>>();
        Integer sum[] = new Integer[nums.length];
        for (int i = 0 ; i < nums.length; i ++){
            sum[i] = nums[i];
        }
        if (nums.length==0){
            return new ArrayList<>();
        }
        sGroup(sum,0,group);
        return group;
    }
    public static void sGroup(Integer []sum,int i,List<List<Integer>> group){
        int len=sum.length;
        if (i == len-1){
            List<Integer> a = new ArrayList<>();
                   a = Arrays.asList(sum.clone());
            if (!group.contains(a)){
                group.add(a);
            }

            return;
        }
        sGroup(sum,i+1,group);
        for (int m = i+1; m < len ; m++){
            if (sum[m]!=sum[i]){
                Integer temp = sum[m];
                sum[m] = sum[i];
                sum[i] = temp;
                sGroup(sum,i+1,group);
                temp = sum[m];
                sum[m] = sum[i];
                sum[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int []a = new int[]{2,2,1,1};
        List<List<Integer>> group = permute(a);
        System.out.println(group.size());
    }


}
