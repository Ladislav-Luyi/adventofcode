package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PriceCalculator {

    int price = 0;

    HashMap<Character, Integer> aggregates = new HashMap<>();
    public PriceCalculator(Set<Region> regions) {
        for (Region region : regions) {
            price += region.area * region.perimiter;

        }
        System.out.println(aggregates);

        HashMap<Character, Integer> mapping1 = new HashMap<>();


//        for (Map.Entry<Character, Pair> characterPairEntry : aggregates.entrySet()) {
//            Pair value = characterPairEntry.getValue();
//            mapping1.put(characterPairEntry.getKey(), value.perimeter() * value.area() );
////            price += value.perimeter() * value.area();
//        }
        System.out.println(mapping1);


        for (Map.Entry<Character, Integer> characterIntegerEntry : mapping1.entrySet()) {
            price += characterIntegerEntry.getValue();
        }


    }

    public int getPrice() {
        return price;
    }

}
