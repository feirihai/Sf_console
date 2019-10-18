package 希尔排序;

public class Solution {
    public static void main(String[] args) {
        int []arr = new int[]{3,5,2,7,8,1,2,0,4,7,4,3,8};

    }

    // TODO: 2019/10/7 希尔排序 (提升插入排序的效率)
    public static void shellSort(int []arr){
        //遍历所有的步长
        for(int d = arr.length/2; d > 0 ; d/=2){
            //遍历所有的元素
            for (int i = d ; i < arr.length; i++){
                //遍历本组中所有的元素
                for(int j = i-d; j >= 0 ;j-=d ){
                    if(arr[j]>arr[j+d]){
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
        }
    }
}
