package com.yangduan.dorian.algorithm.list;

import com.yangduan.dorian.model.ListNode;

import java.util.*;

/**
 * @author yangduan
 * leetcode no.82 删除链表中重复的元素，重复的不保留。例如：
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 */
public class DeleteDuplicated2 {

    public ListNode deleteDuplicates(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }

        if (head.next != null && head.next.val == head.val) {
            while(head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

}
