package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Garden {

    List<List<Plot>> list = new ArrayList<>();
    Set<Region> regions = new HashSet<>();

    public Garden(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            List<Plot> inner = new ArrayList<>();
            String[] split = string.split("");
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                inner.add(new Plot(i,j, s.charAt(0)));
            }
            list.add(inner);
        }
    }

    void showTrial(){
        for (List<Plot> triples : list) {
            for (Plot triple : triples) {
                System.out.print(triple.i() + " ");
            }
            System.out.println();

        }
    }
    public List<List<Plot>> getPlots(){
        return list;
    }
}
