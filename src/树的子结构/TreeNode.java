package 树的子结构;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //如果树为空就返回false
        if (root1 == null) {return false;}
        if (root2 == null) {return false;}
        //
        return isSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public boolean isSubtree(TreeNode root1,TreeNode root2){
        //先判断子树
        if (root2 == null) {return true;}
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
        }else{
            return false;
        }
    }

    }


