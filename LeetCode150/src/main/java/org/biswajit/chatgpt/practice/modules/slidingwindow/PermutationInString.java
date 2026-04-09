package org.biswajit.chatgpt.practice.modules.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(findPermutationInString("hello", "ooolleoooleh"));
    }

    public static boolean findPermutationInString(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int left = 0, subStrLen = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charFreq.merge(c, 1, Integer::sum);
        }
        subStrLen = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            if (charFreq.containsKey(c)) {
                if (charFreq.get(c) > 0) {
                    subStrLen--;
                }
                charFreq.merge(c, -1, Integer::sum);
            }

            while (right - left + 1 > s1.length()) {
                char lc = s2.charAt(left);
                if (charFreq.containsKey(lc)) {
                    if (charFreq.get(lc) >= 0) {
                        subStrLen++;
                    }
                    charFreq.put(lc, charFreq.get(lc) + 1);

                }
                left++;
            }
            if (subStrLen == 0)
                return true;
        }
        return false;
    }
}
