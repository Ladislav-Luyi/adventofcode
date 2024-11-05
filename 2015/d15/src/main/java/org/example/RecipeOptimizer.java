package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class RecipeOptimizer {
    private final Recipe recipe;

    public RecipeOptimizer(Recipe recipe) {
        this.recipe = recipe;
    }

    public Integer apply(Predicate<Result> predicate){

        return getLists()
                .stream()
                .map(integers -> recipe.calculateCalories(integers.toArray(new Integer[0])))
                .filter(predicate)
                .max(Comparator.comparing(Result::result))
                .orElseThrow(() -> new RuntimeException("not result found")).result();
    }

//    private static List<List<Integer>> getLists() {
//        List<List<Integer>>  list = new ArrayList<>();
//        for (int i = 1; i <= 100; i++ ){
//            for (int j = 1; j <= 100; j++ ){
//                for (int k = 1; k <= 100; k++ ){
//                    for (int l = 1; l <= 100; l++ ){
//                        int sum = i +j +k +l;
//                        if (sum == 100){
//                            list.add(List.of(i,j,k,l));
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }

    private static List<List<Integer>> getLists() {
        int numElements = 4; // Number of elements in each combination
        int maxVal = 100; // Maximum value for each element
        int targetSum = 100; // Desired sum

        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(combinations, new ArrayList<>(), numElements, maxVal, targetSum);

        // Printing results (optional)
//        combinations.forEach(System.out::println);
        return combinations;
    }

    private static void findCombinations(List<List<Integer>> result, List<Integer> tempList,
                                         int remainingElements, int maxVal, int targetSum) {
        // Base case: if no more elements to pick, check if the sum matches the target
        if (remainingElements == 0) {
            if (targetSum == 0) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }

        // Try each value from 1 up to maxVal
        for (int i = 1; i <= maxVal; i++) {
            // for improving performance
            if (i > targetSum) {
                break; // Stop if adding i would exceed the remaining target sum
            }

            tempList.add(i); // Add current value to the combination
            findCombinations(result, tempList, remainingElements - 1, maxVal, targetSum - i);
            tempList.remove(tempList.size() - 1); // Backtrack to try the next value
        }
    }

    private static Predicate<Result> getResultPredicate() {
        return result -> result.calories() == 500;
    }


}
