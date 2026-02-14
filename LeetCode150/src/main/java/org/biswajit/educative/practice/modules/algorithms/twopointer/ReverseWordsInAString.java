package org.biswajit.educative.practice.modules.algorithms.twopointer;

import java.util.Arrays;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String a = "Hello World";
        System.out.println(reverseWords(a));

    }
    public static String reverseWords(String sentence) {

        String[] arr = sentence.trim().split(" ");
        int start = 0;
        int end = arr.length - 1;
        while(end > start){
            String tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            end--;
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <= arr.length-1 ; i++){
            sb.append(arr[i]+" ");
        }


        return sb.toString().trim();
    }
}
