package org.example;

import java.util.ArrayList;
import java.util.List;

public class Trial {
    List<List<Triple>> list = new ArrayList<>();

    public Trial(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            List<Triple> inner = new ArrayList<>();
            String[] split = string.split("");
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                if (s.equals(".")){
                    s = "-1";
                }
                inner.add(new Triple(i,j, Integer.parseInt(s)));
            }
            list.add(inner);
        }
    }

    void showTrial(){
        for (List<Triple> triples : list) {
            for (Triple triple : triples) {
                System.out.print(triple.i() + " ");
            }
            System.out.println();

        }
    }
    public List<List<Triple>> getTrial(){
        return list;
    }

}
