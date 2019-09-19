package 二分查找;

public class Solution {
    public static boolean two_Find(int []a,int target){
        //定义起始位置
        int start = 0;
        //定义结束位置
        int end = a.length-1;
        while (start < end){
            //取中间位置
            int mid = start + end /2;
            //如果目标比中间数大，中间位置+1
            if (target > a[mid]){
                start = mid +1;
            }
            //如果目标比中间数小，中间位置-1
            else if (target < a[mid]){
                end = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []a = {1,5,6,8,9,10};
        System.out.println(two_Find(a,10));
    }

}
