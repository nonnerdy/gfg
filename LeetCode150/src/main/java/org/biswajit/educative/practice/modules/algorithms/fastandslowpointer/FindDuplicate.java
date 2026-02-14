package org.biswajit.educative.practice.modules.algorithms.fastandslowpointer;
//L-287 M
public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(getDuplicate(new int[]{2,5,8,6,8,3,9,8,1,7}));
    }
    public static int getDuplicate(int[] nums){
        int fast = nums[0];
        int slow = nums[0];

        //get the intersection point
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast)
                break;
        }

        //set slow to the start while fast remains in the intersection point and move both at the same speed
        // to meet them at the entry point
        slow = nums[0];
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
