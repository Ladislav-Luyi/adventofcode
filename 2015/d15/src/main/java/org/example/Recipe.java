package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Recipe {
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe() {
    }

    // TODO refactor to return also array before reducment
    public Integer calculateCalories(Integer... spoons){
        if (spoons.length != ingredients.size()){
            throw new RuntimeException("more spoons than ingredients");
        }
        List<List<Integer>> l = new ArrayList<>();
//        List<Integer> calList = ingredients.stream().map(Ingredient::getCalories).toList();
//        l.add(calList);
        List<Integer> capList = ingredients.stream().map(Ingredient::getCapacity).toList();
        l.add(capList);
        List<Integer> durList = ingredients.stream().map(Ingredient::getDurability).toList();
        l.add(durList);
        List<Integer> flaList = ingredients.stream().map(Ingredient::getFlavor).toList();
        l.add(flaList);
        List<Integer> textList = ingredients.stream().map(Ingredient::getTexture).toList();
        l.add(textList);

        // todo adjust it to use spoons lenght
        List<Integer> sums = new ArrayList<>();
        for(int i = 0; i < l.size(); i++){
            int r1 = 0;
            for(int j = 0; j < l.get(i).size(); j++){
                r1 += l.get(i).get(j) * spoons[j];
            }
            sums.add(r1);
        }
        System.out.println("from recipe " + sums);
        // handle minus values -> if minus return 0
        // todo is this correct??
        List<Integer> list = sums.stream().filter(integer -> integer < 0).toList();
        if (!list.isEmpty()){
            return 0;
        }

        return sums.stream()
                .reduce((integer, integer2) -> integer * integer2)
                .orElseThrow();
    }
    void addIngredient(Ingredient i){
        ingredients.add(i);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }



    @Override
    public String toString() {
        return "Recipe{" +
               "ingredients=" + ingredients +
               '}';
    }
}
