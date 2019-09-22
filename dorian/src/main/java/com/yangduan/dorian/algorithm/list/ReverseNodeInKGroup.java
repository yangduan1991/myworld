package com.yangduan.dorian.algorithm.list;

import com.yangduan.dorian.model.ListNode;

import java.util.Stack;

public class ReverseNodeInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(true) {
            int count = 0;
            ListNode temp = head;
            while(null != temp && count < k) {
                stack.push(temp);
                temp = temp.next;
                count ++;
            }

            if(count != k) {
                p.next = head;
                break;
            }

            while(!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            p.next = temp;
            head = temp;

        }
        return dummy.next;
    }

}
