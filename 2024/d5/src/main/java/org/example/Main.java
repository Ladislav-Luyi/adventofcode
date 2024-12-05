package org.example;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String inputRules = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13
            """;

    static String pageInput = """
75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
            """;
    public static void main(String[] args) {
        HashMap<Integer, Set<Integer>> rulesMap = new HashMap<>();
        for (String s : inputRules.split("\n")) {
            String[] split = s.split("\\|");
            int before = Integer.parseInt(split[0]);
            int after  = Integer.parseInt(split[1]);
            rulesMap.merge(before, new HashSet<>(Set.of(after)),(integers, integers2) -> { integers.addAll(integers2);return integers; }  );
        }
//        showRuleMap(rulesMap);
//        part1(rulesMap);
        part2(rulesMap);

    }

    private static void showRuleMap(HashMap<Integer, Set<Integer>> rulesMap) {
        for (Map.Entry<Integer, Set<Integer>> entry : rulesMap.entrySet()) {
            System.out.println( "key " +  entry.getKey() );
            entry.getValue().forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void part2(HashMap<Integer, Set<Integer>> rulesMap) {
        String[] split = pageInput.split("\n");
        List<List<Integer>> r = new ArrayList<>();

        Set<Integer> canContain = null;
        for (String s : split) {
            String[] numbers = s.split(",");
            List<Integer> numberList = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
            if (isValid(numberList, canContain, rulesMap)){
//                r.add(numberList);
            }else{
                // find relevant rules
                HashMap<Integer, Set<Integer>> relevantRules = new HashMap<>();
                for (Map.Entry<Integer, Set<Integer>> setEntry : rulesMap.entrySet()) {
                    Integer key = setEntry.getKey();
                    Set<Integer> rel = setEntry.getValue();
                    if (numberList.contains(key)){
                        Set<Integer> copy = new HashSet<>();
                        for (Integer i : rel) {
                            if (numberList.contains(i)){
                                copy.add(i);
                            }
                        }
                        relevantRules.put(key, copy);
                    }
                }
                System.out.println("for wrong list " + numberList);
                showRuleMap(relevantRules);

                System.out.println("countsNum " +  findLongestReference(relevantRules, 97, 0, 0));
                HashMap<Integer,Integer> map = new HashMap<>();
                for (Integer i : numberList) {
                    map.put(findLongestReference(relevantRules, i,0, 0),i);
                }
                System.out.println("relevance " + map);
                List<Integer> copy = new ArrayList<>(numberList.size());
                for (int j = 0, numberListSize = numberList.size(); j < numberListSize; j++) {
                    copy.add(map.get(j));
                }
                r.add(copy);


//                List<List<Integer>> lists = generatePerm(numberList);
//                for (List<Integer> list : copy) {
//                    if (isValid(list, canContain, rulesMap)){
//                        System.out.println("found " + list);
//                        r.add(list);
//                        break;
//                    }
//                }
            }
            canContain = null;
        }

//        System.out.println(r);
        int sum = 0;
        for (List<Integer> list : r) {

            int middle = list.size() / 2;
            sum += list.get(middle);
        }
        System.out.println(sum);

    }

    private static int findLongestReference(
            HashMap<Integer, Set<Integer>> relevantRules,
            int i,
            int count,
            int biggest) {
        Set<Integer> integers = relevantRules.get(i);
        if (Objects.isNull(integers)){
            return Math.max(biggest, count);
        }
        biggest = Math.max(biggest, count);
        for (Integer integer : integers) {
            biggest = findLongestReference(relevantRules, integer, count+1, biggest);
        }
        return biggest;
    }


    private static void part1(HashMap<Integer, Set<Integer>> rulesMap) {
        String[] split = pageInput.split("\n");
        ArrayList<String> r = new ArrayList<>();

        Set<Integer> canContain = null;
        for (String s : split) {
            String[] numbers = s.split(",");
            List<Integer> numberList = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
            if (isValid(numberList, canContain, rulesMap)){
                r.add(s);
            }
            canContain = null;
        }

//        System.out.println(r);
        int sum = 0;
        for (String s : r) {
            String[] ints = s.split(",");
            int middle = ints.length / 2;

            sum += Integer.parseInt( ints[middle] );

        }
        System.out.println(sum);
    }

    private static boolean isValid(List<Integer> numbers,
                                   Set<Integer> canContain,
                                   HashMap<Integer,
                                   Set<Integer>> rulesMap) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
//            System.out.println("processing " + number);
            if (Objects.isNull(canContain))  {
                canContain = rulesMap.get(number);
//                System.out.println(canContain);
                if (canContain == null){
                    return false;
                }
                continue;
            }
//            System.out.println("canContain");
            if (canContain.contains(number)) {
                canContain = rulesMap.get(number);
                if (i != numbers.size() - 1 && canContain == null){
                    return false;
                }
            } else {
                break;
            }
            if (i == numbers.size() - 1){
                return true;
            }
        }
        return false;
    }
}