package org.biswajit.educative.practice.modules.codinginterviewpatterns.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
//L-256 M
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 5}, {4, 6}, {3, 7}, {6, 8}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));

    }

    public static int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= result.getLast()[1]) {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            } else {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
