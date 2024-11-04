package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // part1 222870
        // part2 117936
        List<Ingredient> list = Arrays.stream(input.split("\n"))
                .map(Main::make)
                .toList();
        Recipe recipe = new Recipe(list);
        RecipeOptimizer recipeOptimizer = new RecipeOptimizer(recipe);
        // part1
        Predicate<Result> allCalories =  result -> true;
        System.out.println( recipeOptimizer.apply(allCalories));
        // part2
        System.out.println( recipeOptimizer.apply(result -> result.calories() == 500));
    }

    static String input = """
Sugar: capacity 3, durability 0, flavor 0, texture -3, calories 2
Sprinkles: capacity -3, durability 3, flavor 0, texture 0, calories 9
Candy: capacity -1, durability 0, flavor 4, texture 0, calories 1
Chocolate: capacity 0, durability 0, flavor -2, texture 2, calories 8
                        """;
    static Pattern pattern = Pattern.compile("(\\w+): capacity (-?\\w+), durability (-?\\w+), flavor (-?\\w+), texture (-?\\w+), calories (-?\\w+)", Pattern.CASE_INSENSITIVE);
    // Sugar: capacity 3, durability 0, flavor 0, texture -3, calories 2
    private static Ingredient make(String s) {
        Matcher m = pattern.matcher(s);
        boolean b = m.find();
        return new Ingredient(
                m.group(1),
                Integer.parseInt(m.group(2)),
                Integer.parseInt(m.group(3)),
                Integer.parseInt(m.group(4)),
                Integer.parseInt(m.group(5)),
                Integer.parseInt(m.group(6))
        );
    }
}