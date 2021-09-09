package leet.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No_160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        No_160 main = new No_160();
        int a[]=new int[]{4,1,8,4,5};
        int b[]=new int[]{5,6,1,8,4,5};
        ListNode headA=null;
        ListNode curA=null;
        for (int i : a) {
            if(curA==null){
                headA=new ListNode(i);
                curA=headA;
            }else{
                curA.next=new ListNode(i);
                curA=curA.next;
            }
        }
        ListNode headB=null;
        ListNode curB=null;
        for (int i : b) {
            if(curB==null){
                headB=new ListNode(i);
                curB=headB;
            }else{
                curB.next=new ListNode(i);
                curB=curB.next;
            }
        }


        System.out.println(main.getIntersectionNode(headA, headB));


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;

        while(curA!=curB){
            curA=curA==null?headB:curA.next;
            curB=curB==null?headA:curB.next;
        }

        return curA;
    }
}


