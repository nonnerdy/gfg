package org.biswajit.educative.practice.modules.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductOfSelfArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findProductArray(new int[]{2,4,0,6})));
        Map<Integer,Integer> a = new HashMap<>();

    }

    public static int[] findProductArray(int[] arr){
        int n = arr.length;
        int i , left = 1;
        int[] product = new int[n];

        //product of left side
        for(i = 0 ; i < n ; i++){
            product[i] = left ;
            left = left * arr[i];
        }
        int right = 1;
        for(i = n - 1; i >= 0 ; i--){
            product[i] = product[i] * right;
            right = right * arr[i];
        }

        return product;
    }
}
