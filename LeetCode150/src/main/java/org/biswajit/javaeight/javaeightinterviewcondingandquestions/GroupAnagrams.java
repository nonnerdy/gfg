package org.biswajit.javaeight.javaeightinterviewcondingandquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = new String[]{"listen","silent","evil","vile","rat","tar"};

       Map<String, List<String>> anagramGroups =  Arrays.stream(arr).collect(Collectors.groupingBy(
                word->{
                    char[] ch = word.toCharArray();
                    Arrays.sort(ch);
                    return new String(ch);
                }
        ));

        System.out.println(anagramGroups);
    }
}
