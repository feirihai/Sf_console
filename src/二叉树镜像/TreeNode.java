package 二叉树镜像;

 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 //二叉树镜像不难发现起始就是交换左右子节点
class Solution {
    public void Mirror(TreeNode root) {
        TreeNode temp;
        if(root!=null)
        {
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            if(root.left!=null)
                Mirror(root.left);
            if(root.right!=null)
                Mirror(root.right);
        }
    }
}
