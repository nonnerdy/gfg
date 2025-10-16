package org.biswajit.leetcode.practice.modules.twopointers;
//LC 202
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int number) {
        int slowPointer = number;
        int fastPointer = getSquareOfANumber(number);

        while(fastPointer != 1 && fastPointer != slowPointer){
            slowPointer = getSquareOfANumber(slowPointer);
            fastPointer = getSquareOfANumber(getSquareOfANumber(fastPointer));
        }
        return fastPointer == 1;
    }

    public static int getSquareOfANumber(int number){
        int square = 0;
        while (number > 0){
            int tmp = number % 10;
            number = number / 10;
            square += Math.pow(tmp,2);
        }
        return square;
    }
}
