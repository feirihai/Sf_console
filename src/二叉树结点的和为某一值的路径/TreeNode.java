package 二叉树结点的和为某一值的路径;
/**
 * 通过栈完成回溯法标记
 */

import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
//利用回溯法层层检查(栈实现)，相等就把路径加上，不相等回溯上一节点
class Solution {
    public static ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    public static Stack<Integer> path = new Stack<Integer>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return new ArrayList<>();
        }
        findPaths(root,target,0);
        return paths;
    }
    public static void findPaths(TreeNode root,int target,int cur){
        if (root==null && cur == target){
            paths.add(new ArrayList(path));
            return;
        }
        if (root == null){
            return;
        }
        path.push(root.val);
        findPaths(root.left,target,cur+root.val);
        path.pop();
        if (root.left==null&&root.right==null){
            return;
        }
        path.push(root.val);
        findPaths(root.right,target,cur+root.val);
        path.pop();
    }

}
