package org.biswajit.educative.practice.modules.algorithms.twopointer;

public class SortColors {
    public static void main(String[] args) {
        int[] a = {2,0,1};
        for(int b : sortColors(a)){
            System.out.print(" "+b);
        }
    }

    public static int[] sortColors(int[] arr){
        int start = 0;
        int current = 0;
        int end = arr.length - 1;

        while(current <= end){
            if(arr[current] == 0){
                int tmp = arr[current];
                arr[current] = arr[start];
                arr[start] = tmp;
                current++;
                start++;
            }
            else if(arr[current] == 1){
                current++;
            }
            else{
                int tmp = arr[current];
                arr[current] = arr[end];
                arr[end] = tmp;
                end--;

            }
        }

        return arr;
    }
}
