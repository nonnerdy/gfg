package com.biswajit.recursion;

public class Print1toN {
    public static void main(String[] args) {
         printNos(10);
    }
    public static void printNos(int N){
        if(N==1){
            System.out.print(N+" ");
            return;
        }
             printNos(N-1);
        System.out.print(N+" ");
    }
    
}
