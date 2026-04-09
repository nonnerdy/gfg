package org.biswajit.chatgpt.practice.modules.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int numberOfReplacements = 2;
        System.out.println(findLongestRepeatingCharacterReplacements(s,numberOfReplacements));


    }

    public static int findLongestRepeatingCharacterReplacements(String s,int k){
        int left = 0, right = 0, mostFreqCharacterFreq = 0, result = 0;
        Map<Character,Integer> characterFreq = new HashMap<>();

        while(right < s.length()){
            Character c = s.charAt(right);
            characterFreq.merge(c,1,Integer::sum);
            //calculate the condition
            // if(windowSize - maxFreq) <= k
            mostFreqCharacterFreq = Math.max(mostFreqCharacterFreq,characterFreq.get(c));

            while((right - left + 1) - mostFreqCharacterFreq > k){
                Character l = s.charAt(left);
                characterFreq.merge(l,-1,Integer::sum);

                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;

        }


        return result;
    }
}
