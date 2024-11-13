package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {

    static List<List<Integer>> listList = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> input = List.of(11, 30, 47, 31, 32, 36, 3, 1, 5, 3, 32, 36, 15, 11, 46, 26, 28, 1, 19, 3);
        combination(input, new ArrayList<>(), 0, 150);
        System.out.println("all combinations " + listList.size());
        Integer minSizeOfValues = listList.stream()
                .min(Comparator.comparing(List::size))
                .map(List::size)
                .orElseThrow();
        Integer numberOfElementsMatchingMinSize = listList.stream()
                .map(List::size)
                .filter(size -> size.equals(minSizeOfValues))
                .findFirst()
                .orElseThrow();
        System.out.println("combinations of min values " + numberOfElementsMatchingMinSize);
    }

    static void combination(
            List<Integer> input,
            List<Integer> tmp,
            int i,
            int target
    ) {
        Integer sum = tmp.stream().reduce(Integer::sum).orElse(0);
        if (sum.equals(target)) {
            listList.add(new ArrayList<>(tmp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int j = i; j < input.size(); j++) {
            Integer get = input.get(j);
            tmp.add(get);
            combination(input, tmp, j + 1, target);
            tmp.remove(get);
        }
    }
}