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
        ArrayList<String> r = new ArrayList<>();

        Set<Integer> canContain = null;
        for (String s : split) {
            String[] numbers = s.split(",");
            if (isValid(s, numbers, canContain, rulesMap)){
                r.add(s);
            }else{
                // find relevant rules
                HashMap<Integer, Set<Integer>> relevantRules = new HashMap<>();
                List<Integer> numberList = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());

                for (Integer number : numberList) {
                    for (Map.Entry<Integer, Set<Integer>> setEntry : rulesMap.entrySet()) {
                        if (setEntry.getValue().contains(number) && numberList.contains(setEntry.getKey())){
                            relevantRules.put(
                                    setEntry.getKey(),
                                    setEntry.getValue()
                            );
                        }
                    }
                }
                System.out.println("for numbers " + Arrays.toString(numbers));
                showRuleMap(relevantRules);
                // find first key from relevant rules
                int firstKey = -1;
                for (Map.Entry<Integer, Set<Integer>> entry : relevantRules.entrySet()) {
                    Integer key = entry.getKey();
                    boolean isFirstKey = true;
                    for (Map.Entry<Integer, Set<Integer>> setEntry : relevantRules.entrySet()) {
                        if (setEntry.getValue().contains(key)){
                            isFirstKey = false;
                        }
                    }
                    if (isFirstKey){
                        firstKey = key;
                    }
                }
                System.out.println("firstKey " + firstKey);
                // find second correct second position


            }
            canContain = null;
        }

        System.out.println(r);
        int sum = 0;
        for (String s : r) {
            String[] ints = s.split(",");
            int middle = ints.length / 2;

            sum += Integer.parseInt( ints[middle] );

        }
        System.out.println(sum);

    }

    private static void part1(HashMap<Integer, Set<Integer>> rulesMap) {
        String[] split = pageInput.split("\n");
        ArrayList<String> r = new ArrayList<>();

        Set<Integer> canContain = null;
        for (String s : split) {
            String[] numbers = s.split(",");
            if (isValid(s, numbers, canContain, rulesMap)){
                r.add(s);
            }
            canContain = null;
        }

        System.out.println(r);
        int sum = 0;
        for (String s : r) {
            String[] ints = s.split(",");
            int middle = ints.length / 2;

            sum += Integer.parseInt( ints[middle] );

        }
        System.out.println(sum);
    }

    private static boolean isValid(String s, String[] numbers, Set<Integer> canContain, HashMap<Integer, Set<Integer>> rulesMap) {
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
//            System.out.println("processing " + number);
            if (Objects.isNull(canContain))  {
                canContain = rulesMap.get(number);
                System.out.println(canContain);
                continue;
            }
//            System.out.println("canContain");
            if (canContain.contains(number)) {
                canContain = rulesMap.get(number);
            } else {
                break;
            }
            if (i == numbers.length - 1){
                return true;
            }
        }
        return false;
    }
}