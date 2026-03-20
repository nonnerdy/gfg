package org.biswajit.javaeight.javaeightinterviewcondingandquestions.findduplicatesinanarray;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,2,3,5,6,7,8,8};

//        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(
//                Function.identity(),Collectors.counting()
//        )).entrySet().stream().filter(entry->entry.getValue()>1)
//                .map(Map.Entry::getKey).toList();





























        Map<Integer,Long> result = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        )).entrySet().stream().filter(map->map.getValue()>1).collect(Collectors.toMap(
                Map.Entry::getKey,Map.Entry::getValue
        ));
        System.out.println(result);

    }
}
