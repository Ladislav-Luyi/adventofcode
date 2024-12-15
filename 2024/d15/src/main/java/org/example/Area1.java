package org.example;

import java.util.ArrayList;
import java.util.List;

public class Area1 {
    private final List<List<Character>> list;

    public Area1(List<String> input) {
        List<List<Character>> list = new ArrayList<>();
        for (String lines : input) {
            List<Character> chars = new ArrayList<>();
            for (String s : lines.split("")) {
                chars.add(s.charAt(0));
            }
            list.add(chars);
        }
        this.list = list;
    }

    public List<List<Character>> getArea() {
        return list;
    }

    public void show(){
        for (List<Character> characters : list) {
            for (Character character : characters) {
                System.out.print( character + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("####################################");
    }

    public int sumOfCoordinates(){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Character> characters = list.get(i);
            for (int j = 0; j < characters.size(); j++) {
                Character character = characters.get(j);
                if (character.equals('O')){
                    sum += 100 * i + j;
                }
            }
        }
        return sum;
    }


}
