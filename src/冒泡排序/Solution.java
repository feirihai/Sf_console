package 冒泡排序;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{5,7,2,9,4,1,0,5,7};

    }
    // TODO: 2019/10/7冒泡排序

    /**
     * 5,7,2,9,4,1,0,5,7     比较length-1轮
     *
     * @param arr
     */
    public static void bubbleSort(int []arr){
        //控制比较了多少轮
        for (int i = 0 ; i < arr.length-1; i++){
            //控制比较的次数
            for (int j = 0 ; j < arr.length-i ; j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
