package 子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,2,3};
        subsets(nums);
    }
}
