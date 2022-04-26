package com.biswajit.leetcode.medium.linkedlist;

public class SwapNodeInPairs {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
          ListNode head = new ListNode(1);
          ListNode node1 = new ListNode(2);
          ListNode node2 = new ListNode(3);
          ListNode node3 = new ListNode(4);

          

          head.next = node1;
          node1.next = node2;
          node2.next = node3;
          printList(head);



    }

  public static void printList(ListNode node){
          ListNode tmp = node;
          while(tmp!=null){
              System.out.println(tmp.val);
              tmp = tmp.next;
          }
  }

  public static ListNode swapPairs(ListNode head){




          return null;
  }

}
