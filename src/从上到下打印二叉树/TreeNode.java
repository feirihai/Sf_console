package 从上到下打印二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

/**
 * 思想：
 * 遍历队列头节点，判断有无子节点，有就加到队列末尾
 */
class Solution {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (root == null){
            return new ArrayList<Integer>();
        }
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.getFirst();
            deque.pollFirst();
            if (node.left!=null){
                deque.addLast(node.left);
            }
            if (node.right!=null){
                deque.addLast(node.right);
            }
            arrayList.add(node.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        ArrayList arrayList = PrintFromTopToBottom(node);
        for (int i = 0 ; i < arrayList.size() ; i++){
            System.out.println(arrayList.get(i));
        }
    }
}
