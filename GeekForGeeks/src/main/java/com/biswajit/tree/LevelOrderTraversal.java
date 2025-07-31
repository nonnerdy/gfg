package com.biswajit.tree;

//Breadth first search in binary tree

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node{
        int key;
        Node left;
        Node right;
        Node(int k){
            key = k;
        }
    }

    public static void main(String[] args) {
        Node root               = new Node(10);
        root.left               = new Node(20);
        root.left.left          = new Node(8);
        root.left.right         = new Node(7);
        root.left.right.left    = new Node(9);
        root.left.right.right   = new Node(15);
        root.right              = new Node(30);
        root.right.right        = new Node(6);
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(queue.peek().key);
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
            if( queue.peek() != null) {
                System.out.println(queue.peek().key);
            }
        }

    }
}
