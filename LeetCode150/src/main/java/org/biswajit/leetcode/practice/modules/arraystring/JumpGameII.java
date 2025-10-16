package org.biswajit.leetcode.practice.modules.arraystring;

public class JumpGameII {
    public static void main(String[] args) {

    }

        public static int jumps(int[] nums){
        if (nums == null || nums.length <= 1) return 0;

        int jumps = 0;        // number of jumps made
        int currentEnd = 0;   // end of the range reachable with current number of jumps
        int farthest = 0;     // farthest index reachable from indices within the current range

        // we don't need to process the last index, so iterate to nums.length - 2 (or to n-1 safely)
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // when we reach the end of the current range, we must make a jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // optional early exit: if currentEnd already reaches or passes last index
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}
