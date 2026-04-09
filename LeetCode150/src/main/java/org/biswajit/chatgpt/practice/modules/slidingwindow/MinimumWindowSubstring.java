package org.biswajit.chatgpt.practice.modules.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//L-76
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "adobecodebanc";
        String t = "abc";
        System.out.println(findMinimumWindow(s, t));
        ;

    }

    public static String findMinimumWindow(String s, String t) {

        /*
        1. put t and it's character frequency in a map.
        2. initialize an empty map which will be filled with characters from t and with values 0.
        3. count the total values from t freq map.
        4. initialize left and right pointer at the beginning of the string s.
        5. we will move right pointer one by one.
        6. if we encounter any character which is present in s map then we update the value of that map
        7. for every operation in s map we will check the operation count == t map value.
        8. if all the conditions satisfies then we will save the length .
        9. now we will move the left pointer until the operation count disbalances.
        */


//        Map<Character, Integer> characterFreq = new HashMap<>();
//        Map<Character, Integer> currentWindowCharacterFreq = new HashMap<>();
//        int haveOperation = 0, needOperation = 0, left = 0, right = 0,minLength=0;
//
//        for (Character c : t.toCharArray()) {
//            characterFreq.merge(c, 1, Integer::sum);
//            currentWindowCharacterFreq.put(c, 0);
//        }
//        haveOperation = characterFreq.values().stream().reduce(Integer::sum).orElse(0);
//
//        while (right < s.length()) {
//            Character c = s.charAt(right);
//
//            if (currentWindowCharacterFreq.containsKey(c)) {
//                if (haveOperation != needOperation) {
//                    currentWindowCharacterFreq.merge(c, 1, Integer::sum);
//                    if(Objects.equals(currentWindowCharacterFreq.get(c), characterFreq.get(c))){
//                        needOperation++;
//                    }
//                  //  needOperation++;
//                    if(haveOperation == needOperation){
//                        minLength = Math.min(minLength,(right - left)+1);
//                    }
//                    right++;
//                }else{
//                    Character l = s.charAt(left);
//                   // minLength = Math.min(minLength,(right - left)+1);
//                    currentWindowCharacterFreq.merge(l,-1,Integer::sum);
//                    needOperation--;
//                    left++;
//                }
//            }else {
//                right++;
//            }
//        }
//
//
//        return minLength;

//        if (s.length() < t.length()) return "";
//
//        Map<Character, Integer> target = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            target.put(c, target.getOrDefault(c, 0) + 1);
//        }
//
//        Map<Character, Integer> window = new HashMap<>();
//
//        int have = 0;
//        int need = target.size();
//
//        int left = 0;
//        int minLength = Integer.MAX_VALUE;
//        int start = 0;
//
//        for (int right = 0; right < s.length(); right++) {
//
//            char c = s.charAt(right);
//            window.put(c, window.getOrDefault(c, 0) + 1);
//
//            if (target.containsKey(c) &&
//                    window.get(c).intValue() == target.get(c).intValue()) {
//                have++;
//            }
//
//            while (have == need) {
//
//                // Update result
//                if ((right - left + 1) < minLength) {
//                    minLength = right - left + 1;
//                    start = left;
//                }
//
//                char l = s.charAt(left);
//                window.put(l, window.get(l) - 1);
//
//                if (target.containsKey(l) &&
//                        window.get(l) < target.get(l)) {
//                    have--;
//                }
//
//                left++;
//            }
//        }
//
//        return minLength == Integer.MAX_VALUE
//                ? ""
//                : s.substring(start, start + minLength);


        Map<Character,Integer> characterFreCounter = new HashMap<>();
        int left = 0, right = 0, requiredFreq=0,start = 0, minLength=Integer.MAX_VALUE;
        for(Character c : t.toCharArray()){
            characterFreCounter.merge(c,1,Integer::sum);
        }

        requiredFreq = characterFreCounter.values().stream().reduce(Integer::sum).orElse(0);

        while(right < s.length()){
            Character c = s.charAt(right);
            if(characterFreCounter.containsKey(c)){
                characterFreCounter.merge(c,-1,Integer::sum);
               // right++;
                if(characterFreCounter.get(c)>=0){
                    requiredFreq--;
                }
//                if(requiredFreq == 0){
//                    minLength = Math.min(minLength,(right - left)+1);
//                }
//                right++;
            }
            while(requiredFreq == 0){
//                minLength = Math.min(minLength,(right - left)+1);
//                start = left;
                if(minLength > (right - left + 1)){
                    minLength = (right - left + 1);
                    start = left;
                }
                Character l = s.charAt(left);
                if(characterFreCounter.containsKey(l)){
                    characterFreCounter.merge(l,1,Integer::sum);
                    if(characterFreCounter.get(l)>0){
                        requiredFreq++;
                    }
                }
                left++;

            }
            right++;

            }



        System.out.println(minLength);


        return minLength == Integer.MAX_VALUE ? "" : s.substring(start,right);
    }
}
