package com.biswajit.tree;

public class PrintNodesAtSpecificDistance {

        static class Node{
            int key;
            Node left;
            Node right;
            Node(int k){
                key = k;
            }
        }

    public static void main(String[] args) {
        Node root           = new Node(10);
        root.left           = new Node(20);
        root.left.left      = new Node(40);
        root.left.right     = new Node(50);
        root.right          = new Node(30);
        root.right.right    = new Node(70);

        printKthNodes(root,2);

    }
    /*
          10
         /  \
        20   30
       /  \    \
      40  50   70

      k=2;
      O/P => 40 50 70
     */
    public static void printKthNodes(Node root,int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.key+" ");
        }
        else{
            printKthNodes(root.left,k-1);
            printKthNodes(root.right,k-1);
        }
    }
}
