package org.biswajit.educative.practice.modules.datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingIntegerInAnArray {
    public static void main(String[] args) {
        System.out.println(findFirstUnique(new int[]{2, 3, 4, 2, 3}));
    }

    public static int findFirstUnique(int[] nums) {
        Map<Integer, Integer> findFirst = new HashMap<>();

        for (int num : nums) {
            findFirst.put(num, findFirst.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (findFirst.get(num) == 1)
                return num;
        }
        return -1;
    }
}
