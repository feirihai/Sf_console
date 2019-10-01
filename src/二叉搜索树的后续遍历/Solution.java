package 二叉搜索树的后续遍历;
//输入一个数组，判断这个数组是否是二叉搜索树
//二叉搜索树的特点：左节点<根节点<右节点
//遍历的时候，如果遇到比最后一个元素大的节点，就说明它的前面都比最后一个元素小，
// 该元素后面的所有值都必须大于最后一个值，这两个条件必须都要满足。否则就说明该序列
// 不是二叉树后序遍历。
public class Solution {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0){
            return false;
        }
        return CheckSquenceOfBST(sequence,0,sequence.length-1);
    }
    public static boolean CheckSquenceOfBST(int [] sequence,int start,int end) {
        if(start >= end)return true;
        int key = sequence[end];
        int i = start;
        for (;i<end;i++){
            if (sequence[i]>key)
                break;
        }
        for(int j = i ; j < end ; j++){
            if (sequence[j]<key) return false;
        }
        return CheckSquenceOfBST(sequence, 0,i-1)||CheckSquenceOfBST(sequence,i,end-1);


    }
}
