package org.biswajit.leetcode.practice.modules.twopointers;

/*
https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidPallindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome("0P"));

    }

    public static boolean validPalindrome(String s1) {
        //   String s1 = s.replaceAll("[^a-zA-Z]","").toLowerCase();
//        if(s1.length()==1)
//            return true;
//        else if (s1.length() == 2)
//            return s1.charAt(0) == s1.charAt(1);
//        else{
//            int start = 0;
//            int end = s1.length() - 1;
//            while(start < end){
//                if(s1.charAt(start) == s1.charAt(end)){
//                    start++;
//                    end--;
//                }else{
//                    return false;
//                }
//            }
//            return true;
//        }
//
//    }


        int left = 0, right = s1.length() - 1;
        while (left < right) {
            char a = s1.charAt(left);
            char b = s1.charAt(right);

            //convert upper case to lower case
            if (a >= 'A' && a <= 'Z') a = (char) (a + 32);
            if (b >= 'A' && b <= 'Z') b = (char) (b + 32);

            // Skip non-alphanumeric
            if (!((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))) {
                left++;
                continue;
            }
            if (!((b >= 'a' && b <= 'z') || (b >= '0' && b <= '9'))) {
                right--;
                continue;
            }

            // Compare
            if (a != b) return false;

            left++;
            right--;
        }
        return true;
    }
}
