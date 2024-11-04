package org.example;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    // TODO refactor to return also array before reducment
    public Result calculateCalories(Integer... spoons){
        if (spoons.length != ingredients.size()){
            throw new RuntimeException("more spoons than ingredients");
        }
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> calList = ingredients.stream().map(Ingredient::getCalories).toList();

        List<Integer> capList = ingredients.stream().map(Ingredient::getCapacity).toList();
        l.add(capList);
        List<Integer> durList = ingredients.stream().map(Ingredient::getDurability).toList();
        l.add(durList);
        List<Integer> flaList = ingredients.stream().map(Ingredient::getFlavor).toList();
        l.add(flaList);
        List<Integer> textList = ingredients.stream().map(Ingredient::getTexture).toList();
        l.add(textList);

        int callories = 0;
        for(int i = 0; i < calList.size(); i++){
                callories += calList.get(i) * spoons[i];
        }


        // todo adjust it to use spoons lenght
        List<Integer> sums = new ArrayList<>();
        for(int i = 0; i < l.size(); i++){
            int r1 = 0;
            for(int j = 0; j < l.get(i).size(); j++){
                r1 += l.get(i).get(j) * spoons[j];
            }
            sums.add(r1);
        }

        List<Integer> list = sums.stream().filter(integer -> integer < 0).toList();
        if (!list.isEmpty()){
            return new Result(0, 0);
        }
        Integer i = sums.stream()
                .reduce((integer, integer2) -> integer * integer2)
                .orElseThrow();
        return new Result(i, callories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
               "ingredients=" + ingredients +
               '}';
    }
}
