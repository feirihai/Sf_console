package 和为S的两个数字;
import java.util.ArrayList;
public class Solution {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int index;
        Integer flag1=null,flag2=null;
        if (array.length==0||array.length==1){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = 100000000;
        //二分搜索来做
        for (int i = 0 ; i < array.length ; i++){
            index = array[i];
            if (index > sum){
                continue;
            }
            Boolean a;
            int target = sum - index;
            if (target > index){
                 a = isHave(array,target,i,array.length);
            }else if (target < index){
                 a = isHave(array,target,0,i);
            }else {
                 a = isHave(array,target,i+1,array.length);
            }

            if (a){
                if (index*target < max){
                    max = index*target;
                    flag1 = index;
                    flag2 = target;
                }
            }
        }
        if (flag1==null||flag2==null){
            return new ArrayList<Integer>();
        }
        list.add(flag1);
        list.add(flag2);
    return list;
    }
    static boolean isHave(int [] array,int target,int i,int j){
        int begin = i;
        int end = j;
        while(begin < end){
            int mid = (begin + end) /2;
            if (target < array[mid]){
                end = mid-1;
            }else if(target > array[mid]){
                begin = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []arrary = new int[]{1,2,4,7,11,15};
        ArrayList a = FindNumbersWithSum(arrary,15);
        System.out.println(a.get(0)+" "+a.get(1));

    }
}
