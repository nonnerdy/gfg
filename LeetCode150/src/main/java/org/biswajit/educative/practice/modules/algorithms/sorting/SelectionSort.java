package org.biswajit.educative.practice.modules.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedArrAscending(new int[]{11,63,21,7,54,1})));
        System.out.println(Arrays.toString(sortedArrDescending(new int[]{11,63,21,7,54,77})));
    }
    public static int[] sortedArrAscending(int[] arr){
        int arrSize = arr.length - 1;
        for(int i = 0 ; i < arrSize ; i++){
            int min = findMinIndex(arr,i,arrSize);

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }

    public static int[] sortedArrDescending(int[] arr){
        int arrSize = arr.length - 1;
        for(int i = 0 ; i < arrSize ; i++){
            int min = findMaxIndex(arr,i,arrSize);

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }

    public static int findMinIndex(int[] arr, int i ,int size){
        int minElement = i;
        for(int j = i ; j <= size ; j++){
            if(arr[j] < arr[minElement]){
                minElement = j;
            }
        }
        return minElement;
    }
    public static int findMaxIndex(int[] arr,int i , int size){
        int maxElement = i;
        for(int j = i ; j <= size ; j++){
            if(arr[j] > arr[maxElement]){
                maxElement = j;
            }
        }
        return maxElement;
    }
}
