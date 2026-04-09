package org.biswajit.chatgpt.practice.modules.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//L-3
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println("Longest substring without repeating character is : "+longestSubstring(s));

    }

    public static int longestSubstring(String s){
//        Map<Character,Integer> wordCounter = new HashMap<>();
//        int maxLength = 0;
//        int left=0,right=0;
//        while(right < s.length()){
//            Character c = s.charAt(right);
//            if(wordCounter.containsKey(c) && wordCounter.get(c)>=left){
//                wordCounter.put(c,left);
//                left++;
//            }else{
//                wordCounter.put(c,right);
//                maxLength = Math.max(maxLength,(right - left)+1);
//                right++;
//            }
//        }


        Set<Character> track = new HashSet<>();
        int left = 0,right = 0, maxLength = Integer.MIN_VALUE;

        while(right < s.length()){
            if(track.add(s.charAt(right))){
                right++;
            }else{
                track.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, (right - left ));

        }


        return maxLength;
    }
}
