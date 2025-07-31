package com.biswajit.tree;

public class TreeHeight {
    private static class Node{
        int key;
        Node left;
        Node right;
        Node(int k){
            key = k;
        }
    }
/*
        10
        / \
       8   30
           / \
          40  50
              /
             70
 */
    public static void main(String[] args) {
        Node root               = new Node(10);
        root.left               = new Node(8);
        root.right              = new Node(30);
        root.right.left         = new Node(40);
        root.right.right        = new Node(50);
        root.right.right.left   = new Node(70);

        System.out.println("Tree height --> "+treeHeight(root));

    }
    //  output => 4
    public static int treeHeight(Node root){
        if(root == null){
            return 0;
        }
        else{
            return Math.max(treeHeight(root.left),treeHeight(root.right))+1;
        }
    }
}
