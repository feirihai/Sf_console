package 从尾到头打印链表;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }

    }
class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode cur = listNode;
        while (cur!=null){
            arrayList.add(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0 ; i < arrayList.size() ; i++){
            a.add(arrayList.get(arrayList.size()-1-i));
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ArrayList<Integer> a  = printListFromTailToHead(listNode);
    }
}