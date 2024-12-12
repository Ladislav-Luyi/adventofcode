package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PriceCalculator {

    int price = 0;
    int discountedPrice = 0;

    HashMap<Character, Integer> aggregates = new HashMap<>();
    public PriceCalculator(Set<Region> regions, SideCalculator calculator) {
        for (Region region : regions) {
            price += region.area * region.perimiter;

        }
        System.out.println(aggregates);


        for (Region region : regions) {
            System.out.println(region);
            discountedPrice += region.area * region.sides;

        }
//        System.out.println(mapping);
//        System.out.println(calculator.getSides());



    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice() {return discountedPrice; }

}
