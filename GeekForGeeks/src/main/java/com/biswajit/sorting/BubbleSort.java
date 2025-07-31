package com.biswajit.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {12,3,2,5,67,78};
        sort(a);
    }
/*

 */
    public static void sort(int[] data){

        for (int i = 0; i<data.length - 1 ; i++){
             for(int j = i+1; j < data.length - 1; j++){
                 if(data[i] > data[j]){
                     int tmp = data[i];
                     data[i] = data[j];
                     data[j] = tmp;
                 }
             }
        }

        System.out.println(Arrays.toString(data));
    }
}
