package org.biswajit.leetcode.practice.modules.arraystring;

/*
LC - 55
https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }

    public static boolean canJump(int[] nums){
        int maxReach = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > maxReach) return false;
            maxReach = Math.max(maxReach , i + nums[i]);
        }
        return true;
    }
}
