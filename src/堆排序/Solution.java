package 堆排序;

/**
 * 对于任何一颗子树而言，父节点都大于它任何一个子节点
 * 大顶堆：父节点大于任何一个字节点（升序）
 * 小顶堆：任何一个子节点都比父节点大（降序）
 */

/**
 * 1、先找到最后一个非叶子节点调整
 */
public class Solution {
    public static void main(String[] args) {
        int []arr = new int[]{9,6,8,7,0,1,10,4,2};
    }
    public static void heapSort(int []arr){
        //开始是最后一个非叶子节点，即最后一个节点的父节点
        int start = (arr.length-1)/2;
        //结束位置就是数组的长度减1
        //调整为大顶堆
        for(int i = start; i >= 0 ; i-- ){
            maxHead(arr,arr.length,i);
        }
        //先把数组中的第0个和堆中的最后一个数交换位置，在把前面的处理为大顶堆
        for (int i = arr.length-1 ; i > 0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHead(arr,i,0);
        }
    }

    public static void maxHead(int []arr,int size,int index){
        //通过index找到左子节点
        int leftNode = 2*index+1;
        //有字节点
        int rightNode = 2*index+2;
        int max = index;
        //和两个子节点分别对比，找出最大的节点
        if ( leftNode<size&&arr[leftNode]>arr[max]){
            max = leftNode;
        }
        if (rightNode<size&&arr[rightNode]>arr[max]){
            max = rightNode;
        }
        //交换位置
        if (max!=index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //交换位置以后可能会破坏之前拍好的堆
            maxHead(arr,size,max);
        }

    }
}
