package org.biswajit.leetcode.practice.modules.hashmap;

/*
LEETCODE 383
https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
    public static void main(String[] args) {

    }
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> magazineCharCount = new HashMap<>();
        for(char c : magazine.toCharArray()){
            magazineCharCount.put(c,magazineCharCount.getOrDefault(c,0)+1);
        }

        for(char c : ransomNote.toCharArray()){
            if(magazineCharCount.containsKey(c) && magazineCharCount.get(c) > 0){
                magazineCharCount.put(c,(magazineCharCount.get(c) - 1));
            }
            else{
                return false;
            }
        }
        return true;
    }

    //most efficient solution
    public boolean canConstruct_eff(String ran, String mag) {
        int[] check = new int[26];
        for(char c: ran.toCharArray()){
            int i = mag.indexOf(c,check[c-'a']);
            if(i==-1)   return false;
            check[c-'a']=i+1;
        }
        return true;
    }
}
