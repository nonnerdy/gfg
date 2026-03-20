package org.biswajit.javaeight.javaeightinterviewcondingandquestions.sortarray;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee("Biswajit Jana",2600000L,"JAVA FULLSTACK"),
                new Employee("Sudipta Dalui",2800000L,"DB"),
                new Employee("Anuj Yadav",4000000L, "FRONTEND"),
                new Employee("Sayantan Bhattacharya",1600000L,"DB"),
                new Employee("Sreetama", 1500000L,"FRONTEND"));

        List<String> names = employees.stream().sorted(Comparator.comparing(Employee::getName)).map(Employee::getName).toList();
        System.out.println(names);

       List<String> reverseOrder = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).map(Employee::getName).toList();
        System.out.println(reverseOrder);

        //highest salary from db department

        Optional<Employee> emps = employees.stream().filter(emp -> emp.getDepartment().equals("DB")).max(Comparator.comparing(Employee::getSalary));
        System.out.println("Highest salary in HR dept : " +emps.get().getName());

        //average of even numbers

        int [] arrEven = new int[]{1,2,3,4,5,6,7,8,9,10};

        double average = Arrays.stream(arrEven).filter(el->el%2==0).average().orElse(0);

        System.out.println("Average of even numbers "+average);

        int [] findDuplicateAndFreq = new int[]{1,3,5,4,3,7,8,1,2,5,5,8,9};

        Map<Integer,Long> res = Arrays.stream(findDuplicateAndFreq).boxed().collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println(res);

        //find first non repeating character

        Map<Character,Integer> charCount = new LinkedHashMap<>();

        String s = "swiss";

        for(Character c : s.toCharArray()){
            charCount.merge(c, 1, Integer::sum);
        }

        for(Map.Entry<Character,Integer> ch :charCount.entrySet()){
            if(ch.getValue()==1){
                System.out.println("First non repeating character is : "+ch.getKey());
                break;
            }
        }

        //longest substring without repeating character
        String str = "abcabcbb";
        /*
        a
         */

        Map<Character,Integer> visitedCharacter = new HashMap<>();
        int maxLength = 0;

        for(int right = 0 , left = 0; right < str.length() ; right++){
            char currentCharacter = str.charAt(right);
            if(visitedCharacter.containsKey(currentCharacter) &&
                visitedCharacter.get(currentCharacter) >= left){
                left = visitedCharacter.get(currentCharacter)+1;
            }
            maxLength = Math.max(maxLength,right - left + 1);
            visitedCharacter.put(currentCharacter,right);
        }

        System.out.println("max length of non repeating characters : "+maxLength);

        //group anagrams

        String[] strArr = new String[]{"listen","silent","evil","vile","rat","tar"};



        System.out.println(Arrays.toString(strArr));

        Map<String,List<String>> group = new HashMap<>();

        for(String st : strArr){
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String a = new String(ch);

//            if(group.containsKey(a))   {
//                Set<String> set = group.get(a);
//                set.add(st);
//                group.put(a,set);
//            }else{
//                Set<String> set1 = new HashSet<>();
//                set1.add(st);
//                group.put(a,set1);
//            }

            group.computeIfAbsent(a, k->new ArrayList<>()).add(st);


        }

        System.out.println(group);

        //second largest number in an array
        int[] apr = new int[]{1,2,3,4,5,6,7,8,9};
        Optional<Integer> secondLargest = Arrays.stream(apr).distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondLargest.ifPresent(System.out::println);

        //find second highest number
        int[] arrHigh = new int[]{2,3,4,5,6,7,8,9};
       int a  =  Arrays.stream(arrHigh).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("second highest number "+a);

        //find most fequent element
        int[] freqElement = new int[]{1,2,3,3,4,4,4,5};

        Map<Integer,Long> rs = Arrays.stream(freqElement).boxed().collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst()
                .stream().collect(Collectors.toMap(
                        Map.Entry::getKey,Map.Entry::getValue
                ));

        System.out.println("most frequent element "+rs);


        //flatten nested list

        List<List<Integer>> numbers =
                List.of(
                        List.of(1,2,3),
                        List.of(4,5),
                        List.of(6,7,8)
                );

        List<Integer> tr = numbers.stream().flatMap(Collection::stream).toList();
        System.out.println("flatmap "+tr);

        //partition number into even and odd
        int[] partitionNum = new int[]{1,2,3,4,5,6};

        Map<Boolean, List<Integer>> result = Arrays.stream(partitionNum).boxed()
                .collect(Collectors.partitioningBy(
                        n->n%2==0
                ));

        System.out.println("Partition "+result);

        //find longest substring
        List<String> words = List.of("java","microservices","docker","spring");

        String jh = words.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
        System.out.println("longest string in a array : "+jh);

        //"swiss"

        String sw = "swiss";

        Character rp = sw.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),LinkedHashMap::new,Collectors.counting()
                )).entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(rp);

    }
}
