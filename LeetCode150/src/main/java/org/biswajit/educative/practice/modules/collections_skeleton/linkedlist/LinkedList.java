package org.biswajit.educative.practice.modules.collections_skeleton.linkedlist;

import java.util.List;

public class LinkedList {
    public ListNode head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(List<Integer> values){
        head = null;
        createLinkedList(values);
    }

    private void createLinkedList(List<Integer> values){
        if(values.isEmpty()){
            head = null;
            return;
        }

        head = new ListNode(values.get(0));
        ListNode current = head;

        for(int i = 0 ; i < values.size() ; i++){
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
    }
}


