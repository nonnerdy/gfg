package org.biswajit.chatgpt.practice.modules.twopointer;

import java.util.HashMap;
import java.util.Map;
//L-3
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcbacd";
        System.out.println("Longest substring without repeating character is : "+longestSubstring(s));

    }

    public static int longestSubstring(String s){
        Map<Character,Integer> wordCounter = new HashMap<>();
        int maxLength = 0;
        int left=0,right=0;
        while(right < s.length()){
            Character c = s.charAt(right);
            if(wordCounter.containsKey(c) && wordCounter.get(c)>=left){
                wordCounter.put(c,right);
                left++;
            }else{
                wordCounter.put(c,right);
                maxLength = Math.max(maxLength,(right - left)+1);
                right++;
            }
        }


        return maxLength;
    }
}
