package org.biswajit.educative.practice.modules.algorithms.twopointer;

import org.biswajit.educative.practice.modules.collections_skeleton.linkedlist.LinkedList;
import org.biswajit.educative.practice.modules.collections_skeleton.linkedlist.ListNode;
import org.biswajit.educative.practice.modules.collections_skeleton.linkedlist.PrintList;

import java.util.Arrays;
import java.util.List;

public class FindNthNode {
    public static void main(String[] args) {
        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(23, 89, 10, 5, 67, 39, 70, 28),
                Arrays.asList(34, 53, 6, 95, 38, 28, 17, 63, 16, 76),
                Arrays.asList(288, 224, 275, 390, 4, 383, 330, 60, 193),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12)
        );

        int[] n = {4, 1, 6, 9, 11};

        for (int i = 0; i < inputs.size(); i++) {
            LinkedList inputLinkedList = new LinkedList(inputs.get(i));
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.display(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.display(removeNthLastNode(inputLinkedList.head, n[i]));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static ListNode removeNthLastNode(ListNode head, int n) {
        /*
        Bruteforce approach

        int size = 0;
        ListNode current = head;
        while (current.next != null){
            size++;
            current = current.next;
        }

        int traverseTill = size - n + 1;

        current = head;
      //  size = 0;

       for( int j = 0 ; j < size - n ; j++){
           current = current.next;
       }
       current.next = current.next.next;

        return head;
        */

        /*
        fast and slow pointer / 2 pointer approach
        intialize both the pointer at the head
        move first pointer nth steps;
        then move both the pointerts until first pointer reaches at the end
         */

        ListNode left = head;
        ListNode right = head;

        for( int i = 0 ; i < n ; i ++){
            right = right.next;
        }

        if(right == null){
            return head.next;
        }

        while(right.next != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }

}
