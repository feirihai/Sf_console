package 二叉搜索树与双向链表;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
class Solution {
    ArrayList <TreeNode> linkedList = new ArrayList<TreeNode>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        Converts(pRootOfTree);
        return Convert(linkedList);
    }
    //todo 中序遍历后就是有序的列保存在list中
    public void Converts(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return ;
        }
        if (pRootOfTree.left!=null){
            Converts(pRootOfTree.left);
        }
        linkedList.add(pRootOfTree);
        if (pRootOfTree.right!=null){
            Converts(pRootOfTree.right);
        }
    }
    //遍历list，修改指针
    public TreeNode Convert(ArrayList<TreeNode> list){
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }
}
