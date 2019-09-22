package com.yangduan.dorian.algorithm.list;

import com.yangduan.dorian.model.ListNode;

public class ReverseListNode {

    public ListNode recursiveSolution(ListNode head){
        if(null == head || null == head.next) {
            return head;
        }

        ListNode newHead = recursiveSolution(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode iterativeSolution(ListNode head){
        if(null == head || null == head.next) {
            return head;
        }

        ListNode pre = null;
        while(null != head) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
