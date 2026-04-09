package org.biswajit.chatgpt.practice.modules.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInaString {
    public static void main(String[] args) {
        System.out.println(getFindAllAnagrams("cbaebabacd","abc"));
    }

    public static List<Integer> getFindAllAnagrams(String s , String p){
        Map<Character,Integer> charFreq = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int left=0,right=0,operationCounter=0,pLength=p.length();

        for(char c : p.toCharArray()){
            charFreq.merge(c,1,Integer::sum);
        }

        for( right = 0 ; right < s.length() ; right++){
            char rc = s.charAt(right);
            if(charFreq.containsKey(rc) ){
                charFreq.put(rc,charFreq.get(rc)-1);
                if(charFreq.get(rc)>= 0) {
                    operationCounter++;
                }
            }

            if(right - left + 1 > pLength){
                char lc = s.charAt(left);
                if(charFreq.containsKey(lc)){
                    charFreq.merge(lc,1,Integer::sum);
                    if(charFreq.get(lc)> 0) {
                        operationCounter--;
                    }
                }
                left++;
            }
            if(operationCounter == pLength ){
                result.add(left);
            }
        }
        return result;
    }
}
