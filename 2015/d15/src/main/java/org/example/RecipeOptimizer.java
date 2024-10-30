package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RecipeOptimizer {
    private final Recipe recipe;

    public RecipeOptimizer(Recipe recipe) {
        this.recipe = recipe;
    }

    public int apply(){
//        List<Variation> list = new ArrayList<>();
//
//        Variation v1 = new Variation(
//                List.of(new NumWithDirection(50, '+'),
//                        new NumWithDirection(50, '-'))
//        );
//
//        Variation v2 = new Variation(
//                List.of(new NumWithDirection(50, '-'),
//                        new NumWithDirection(50, '+'))
//        );
//        list.add(v1);
//        list.add(v2);
        List<Variation> list = getVariations();
        int result = recipe.calculateCalories(25,25,25,25);
        System.out.println("proportional result " + result);
        // calculate variations
        for (Variation variation : list) {
            variation.getList().forEach(NumWithDirection::stepInDirection);
            Integer[] array = variation.getList().stream().map(NumWithDirection::getI).toList().toArray(new Integer[0]);
            Integer i = recipe.calculateCalories(array);
            variation.setResult(i);
        }
        // found best variation
        System.out.println("all results from variations " + list);
        Variation optimalVariation = list.stream().max(Comparator.comparing(o -> o.result)).orElseThrow(() -> new RuntimeException("not optimal variation"));
        System.out.println("optimal variations " + optimalVariation.getList());
        // return proportional result if it is best one
        if (optimalVariation.result > result){
            return result;
        }
        // improve found variations
        result = optimalVariation.result;
        System.out.println("first result " + result);
        while (true){
            optimalVariation.getList().forEach(NumWithDirection::stepInDirection);
            Integer[] array = optimalVariation.getList().stream().map(NumWithDirection::getI).toList().toArray(new Integer[0]);
            System.out.println("spoons " + Arrays.toString(array));
            Integer i = recipe.calculateCalories(array);
            System.out.println("tmp result "  + result);
            if (i > result){
                result = i;
            }else{
                break;
            }
        }

        return result;
    }

    private List<Variation> getVariations() {
        List<Variation> list = new ArrayList<>();
        int n = recipe.getIngredients().size();
        int m = 100 / n;
        /*
+ - - -
- + - -
- - + -
- - - +

+ + - -
- + + -
- - + +
         */
        list.add(makeVariation(25,'+','-','-','-'));
        list.add(makeVariation(25,'-','+','-','-'));
        list.add(makeVariation(25,'-','-','+','-'));
        list.add(makeVariation(25,'-','-','-','+'));

        list.add(makeVariation(25,'+','+','-','-'));
        list.add(makeVariation(25,'-','+','+','-'));
        list.add(makeVariation(25,'-','-','+','+'));

        return list;
    }

    private Variation makeVariation(int i, Character... c) {
        List<NumWithDirection> list =
                Arrays.stream(c)
                        .map(character -> new NumWithDirection(i, character)).toList();
        return new Variation(list);

    }

    public static class Variation{

        Integer result = 0;
        private List<NumWithDirection> list = new ArrayList<>();
        private void add(NumWithDirection n){
            list.add(n);
        }

        public void setList(List<NumWithDirection> list) {
            this.list = list;
        }

        public List<NumWithDirection> getList() {
            return list;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public Variation(List<NumWithDirection> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "Variation{" +
                   "result=" + result +
                   ", list=" + list +
                   '}';
        }
    }


    public static class NumWithDirection{
        private int i;
        private char sign;

        public NumWithDirection() {
        }

        public NumWithDirection(int i, char sign) {
            this.i = i;
            this.sign = sign;
        }

        public void stepInDirection(){
            if (sign == '+'){
                inc();
            }else if (sign == '-'){
                dec();
            }else{
                throw new RuntimeException("something went wrong");
            }
        }

        public void inc(){
            i++;
        }

        public void dec(){
            i--;
        }
        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public char getSign() {
            return sign;
        }

        public void setSign(char sign) {
            this.sign = sign;
        }

        @Override
        public String toString() {
            return "NumWithDirection{" +
                   "i=" + i +
                   ", sign=" + sign +
                   '}';
        }
    }
}
