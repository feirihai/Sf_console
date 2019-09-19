package 两数相加;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        //用于进位的变量
        int flag = 0;
        while (l1!=null || l2!=null){
            //缺失位补0
            int x = l1==null ? 0 : l1.val;
            int y = l2==null ? 0 : l2.val;
            int sum = x+y+flag;
            //如果大于10，进位
            if (sum >= 10){  cur.next = new ListNode(sum - 10); flag = 1;}
            else{   cur.next = new ListNode(sum); flag = 0;}
            //指向下一个节点
            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if (flag > 0){
            cur.next = new ListNode(1);
            cur = cur.next;
        }

        return pre.next;
    }
}
