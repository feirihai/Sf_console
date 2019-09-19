package 重建二叉树;

import java.util.Arrays;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  class Solution {
      /*public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
          if(pre.length == 0||in.length == 0){
              return null;
          }
          TreeNode node = new TreeNode(pre[0]);
          for(int i = 0; i < in.length; i++){
              if(pre[0] == in[i]){
                  node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                  node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
              }
          }
          return node;
      }*/
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0|| in.length ==0){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        int index = index(in,0,in.length,pre[0]);
        treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,index+1),Arrays.copyOfRange(in,0,index));
        treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length),Arrays.copyOfRange(in,index+1,in.length));

        return treeNode;
    }
    public static int index(int[] in,int in_start,int in_end, int root){
        int index = 0;
        for (int i = in_start ; i < in_end ; i++){
            if (in[i] == root){
                index = i;
            }
        }
        return index;
    }
    //后续遍历
    public static void behind(TreeNode treeNode){
        if (treeNode!=null){
            behind(treeNode.left);
            behind(treeNode.right);
            System.out.println(treeNode.val);
        }
    }
    //前序遍历
    public static void front(TreeNode treeNode){
        if (treeNode!=null){
            System.out.println(treeNode.val);
            front(treeNode.left);
            front(treeNode.right);
        }
    }
    //中序遍历
    public static void in(TreeNode treeNode){
        if (treeNode!=null){
            in(treeNode.left);
            System.out.println(treeNode.val);
            in(treeNode.right);
        }
    }
      public static void main(String[] args) {
          int []pre = {1,2,4,7,3,5,6,8};
          int []in = {4,7,2,1,5,3,8,6};
          TreeNode treeNode = reConstructBinaryTree(pre,in);
          behind(treeNode);
      }


}
