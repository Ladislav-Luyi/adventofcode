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

    private static List<List<Integer>> getLists() {
        List<List<Integer>>  list = new ArrayList<>();
        for (int i = 1; i <= 100; i++ ){
            for (int j = 1; j <= 100; j++ ){
                for (int k = 1; k <= 100; k++ ){
                    for (int l = 1; l <= 100; l++ ){
                        int sum = i +j +k +l;
                        if (sum == 100){
                            list.add(List.of(i,j,k,l));
                        }
                    }
                }
            }
        }
        return list;
    }


    private static Predicate<Result> getResultPredicate() {
        return result -> result.calories() == 500;
    }


}
