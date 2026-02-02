package org.biswajit.educative.practice.modules.datastructures.graph.basic;

import java.util.LinkedList;

public class Graph {
    int vertices;
    DoublyLinkedList<Integer> adjacencyList[];

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for(int i = 0 ; i < vertices ; i++){
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source, int destination ){
        if(source < vertices && destination < vertices){
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }

    public void printGraph(){
        System.out.println(">>Adjacency List of Directed Graph<<");
        for(int i = 0 ; i < vertices ; i++){

        }
    }

}
