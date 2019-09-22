package com.yangduan.dorian.algorithm.list;

import com.yangduan.dorian.model.ListNode;

public class DesignLinkedList {

    static class MyLinkedList {

        ListNode head;
        int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index >= size || index < 0) {
                return -1;
            }
            ListNode temp = head;
            while(index -- > 0) {
                temp = temp.next;
            }
            return temp.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if(head == null) {
                head = new ListNode(val);
            } else {
                ListNode newHead = new ListNode(val);
                newHead.next = head;
                head = newHead;
            }
            size ++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if(head == null) {
                head = new ListNode(val);
            } else {
                ListNode temp = head;
                while(null != temp && null != temp.next) {
                    temp = temp.next;
                }
                temp.next = new ListNode(val);
            }
            size ++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index > size || index < 0) {
                return;
            }

            if(index <= 0) {
                ListNode newNode = new ListNode(val);
                newNode.next = head;
                head = newNode;
                size ++;
                return;
            }

            ListNode temp = head;
            while(index -- > 1) {
                temp = temp.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size ++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index >= size || index < 0) {
                return;
            }

            if(index == 0) {
                head = head.next;
            } else if (index == size - 1) {
                ListNode temp = head;
                while(index -- > 0) {
                    temp = temp.next;
                }
                temp = null;
            } else {
                ListNode temp = head;
                while(index -- > 1) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            size --;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
//        list.addAtHead(1);
//        list.addAtTail(3);
        list.addAtIndex(-1, 0);
        System.out.println(list.get(0));
        list.deleteAtIndex(0);
        System.out.println(list.get(0));
    }

}
