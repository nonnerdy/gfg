package org.biswajit.educative.practice.modules.datastructures.linkedlist;

public class ListDemo {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.printList();
        for(int i = 1 ; i <= 10 ; i++){
            sll.insertAtHead(i);
            sll.printList();
        }
    }
}
