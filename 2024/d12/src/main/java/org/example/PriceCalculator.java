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

        HashMap<Character, Integer> mapping = new HashMap<>();
        for (Region region : regions) {
            mapping.merge(region.getRegionId(), region.plots.size(), Integer::sum);
        }
        System.out.println(mapping);
        System.out.println(calculator.getSides());

        for (Map.Entry<Character, Integer> entry : mapping.entrySet()) {
            discountedPrice += calculator.getSides().get(entry.getKey()) * entry.getValue();
        }


    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice() {return discountedPrice; }

}
