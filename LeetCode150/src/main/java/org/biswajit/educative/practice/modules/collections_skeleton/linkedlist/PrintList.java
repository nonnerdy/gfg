package org.biswajit.educative.practice.modules.collections_skeleton.linkedlist;

public class PrintList {
    public static void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}