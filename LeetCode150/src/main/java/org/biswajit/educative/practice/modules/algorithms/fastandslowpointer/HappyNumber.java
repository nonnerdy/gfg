package org.biswajit.educative.practice.modules.algorithms.fastandslowpointer;


//L-202
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(99999999));
    }

    public static boolean isHappyNumber(int n) {
        if(n== 1 )
            return true;
        if(n==0)
            return false;
        int slow=n,fast=getSquare(getSquare(n));

        while(fast != slow){
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
            System.out.println("Slow ->"+slow);
            System.out.println("Fast ->"+fast);
            if(fast == 1 || slow ==1 ){
                return true;
            }
        }
        return false;
    }
    public static int getSquare(int n){
        int tmp = n;
        int res = 0;
        while(tmp > 0){
            int rem = tmp % 10;
            res +=Math.pow(rem,2);
            tmp = tmp /10;
        }
        return res;
    }
}
