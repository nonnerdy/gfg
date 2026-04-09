package org.biswajit.chatgpt.practice.modules.twopointer;
//L-125
public class ValidPallindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s1) {
        int left = 0,right=s1.length() - 1;
        while(left<right){
            char leftChar = s1.charAt(left);
            char rightChar = s1.charAt(right);

            //convert left char to uppercase
            if(leftChar >='A' && leftChar <='Z'){
                leftChar =(char) (leftChar+32);
            }
            //convert right char to uppercase
            if(rightChar >='A' && rightChar <='Z'){
                rightChar =(char) (rightChar+32);
            }

            if(!((leftChar>='a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9'))){
                left++;
                continue;
            }
            if(!((rightChar>='a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9'))){
                right--;
                continue;
            }

            if(leftChar != rightChar) return false;
            left++;
            right--;

    }
        return true;
    }
}
