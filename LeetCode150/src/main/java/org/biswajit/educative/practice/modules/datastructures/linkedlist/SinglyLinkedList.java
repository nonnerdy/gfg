package org.biswajit.educative.practice.modules.datastructures.linkedlist;

public class SinglyLinkedList<T> {
    public class Node{
        public T data;
        public Node nextNode;
    }

    public Node headNode;
    public int size;

    public SinglyLinkedList(){
        headNode = null;
        size = 0;
    }
    //Helper function that checks if linked list is empty or not
    public boolean isEmpty(){
        return headNode == null;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        headNode = newNode;
        size ++;
    }

    public void printList(){
        if(isEmpty()){
            System.out.println("List is empty!!");
            return;
        }
        Node tmp = headNode;
        System.out.print("List: ");
        while (tmp.nextNode != null){
            System.out.print(tmp.data.toString() + " -> ");
            tmp = tmp.nextNode;
        }
        System.out.println(tmp.data.toString() + " -> null");
    }




}
