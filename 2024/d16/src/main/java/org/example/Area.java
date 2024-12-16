package org.example;

import java.util.ArrayList;
import java.util.List;

public class Area {

    List<List<Node>> list = new ArrayList<>();

    public Area(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            List<Node> inner = new ArrayList<>();
            String[] split = string.split("");
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                inner.add(new Node(i,j, s.charAt(0), Direction.EMPTY));
            }
            list.add(inner);
        }
    }

    void showTrial(){
        for (List<Node> triples : list) {
            for (Node triple : triples) {
                System.out.print(triple.i() + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("#########################################");
    }
    public List<List<Node>> getNodes(){
        return list;
    }
}