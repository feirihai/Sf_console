package 快速排序;

public class Solution {
    public static int[] quickSort(int []a){


        return null;
    }
    public static void sort(int a[],int left,int right){
        if (left>right){
            return;
        }
        //起始
        int start = left;
        //结束
        int end = right;
        //基准
        int key = a[left];
        while(start<end){
            //如果右面的数大于基准，右面的指针向左移
            while (a[end]>=key&&start<end){
                end--;
            }
            //如果左面的数小于基准，左面的指针向右移
            while (a[start]<=key&&start<end){
                start++;
            }
            //当第一次找到交换
            if (start<end) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
        }
        //最后还差一次交换
        a[left] = a[start];
        a[start] = key;
        sort(a,left ,start-1);
        sort(a,start+1,right);
    }

    public static void main(String[] args) {
        int a[]={3,4,1,2,9};
        sort(a,0,a.length-1);
        for (int i = 0 ; i < a.length ; i++){
            System.out.print(a[i]+" ");
        }

    }

}
