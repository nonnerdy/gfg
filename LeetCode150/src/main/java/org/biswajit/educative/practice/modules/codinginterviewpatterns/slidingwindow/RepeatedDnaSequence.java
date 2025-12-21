package org.biswajit.educative.practice.modules.codinginterviewpatterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//187 - https://leetcode.com/problems/repeated-dna-sequences/description/
public class RepeatedDnaSequence {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public static List<String> findRepeatedDnaSequences(String s){
        /*
        1. encode each letter
        A -> 0
        C -> 1
        G -> 2
        T -> 3


         */

        int length = s.length();
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < length - 9 ; i++){
            String sub = s.substring(i,i+10);
            if(set.contains(sub)){
                result.add(sub);
            }else
                set.add(sub);
        }
        return new ArrayList<>(result);
    }
}
