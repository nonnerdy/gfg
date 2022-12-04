package com.biswajit.tree;

public class TreeBasic {
    static class Node{
        int key;
        Node left;
        Node right;
        Node(int k){
            key = k;
        }
    }
//
//           10
//          /  \
//         20   30
//             /  \
//            40  50
//

    public static void main(String[] args) {
        //1.Initialize the tree
        Node root           = new Node(10);
        root.left           = new Node(20);
        root.right          = new Node(30);
        root.right.left     = new Node(40);
        root.right.right    = new Node(50);
        System.out.println("InOrder traversal");
        inorderTraversal(root);
        System.out.println("PreOrder traversal");
        preOrderTraversal(root);
        System.out.println("PostOrder traversal");
        postOrderTraversal(root);
    }
    /*
    output => 20 10 40 30 50
     */
    public static void inorderTraversal(Node root){
       if(root!=null){
           inorderTraversal(root.left);
           System.out.println(root.key);
           inorderTraversal(root.right );
       }
    }
//output => 10,20,30,40,50
    public static void preOrderTraversal(Node root){
        if(root!=null){
            System.out.println(root.key);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right );
        }
    }
/*
output => 20,40,50,30,10
 */
    public static void postOrderTraversal(Node root){
        if(root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right );
            System.out.println(root.key);
        }
    }
}
