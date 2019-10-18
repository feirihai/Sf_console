package 插入排序;

public class Solution {
    public static void main(String[] args) {
        int []arr = new int[]{5,3,2,8,9,1,0};
    }
    public static void insertSort(int []arr){
        //遍历所有的数字
        for (int i = 1 ; i < arr.length ; i++){
            //如果当前数字比前一个数字小
            if(arr[i]<arr[i-1]){
                //把当前数字保存起来
                int temp = arr[i];
                //遍历当前数字前面的所有数字
                int j;
                for(j = i-1; j>=0&&arr[j]>temp ; j--){
                    //把前一个数赋给后一个数
                    arr[j+1] = arr[j];
                }
                //把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
                arr[j+1] = temp;
            }
        }
    }
}
