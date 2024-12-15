package org.example;

import java.util.ArrayList;
import java.util.List;

public class Area3 {
    private final List<List<Character>> list;

    public Area3(List<String> input) {
        List<List<Character>> list = new ArrayList<>();


        for (String lines : input) {
            List<Character> chars = new ArrayList<>();
            for (String s : lines.split("")) {
                char c = s.charAt(0);
                if (c == '@') {
                    chars.add(c);
                    chars.add('.');
                } else if (c == '#') {
                    chars.add(c);
                    chars.add(c);
                } else if (c == 'O') {
                    chars.add('[');
                    chars.add(']');
                } else {
                    chars.add('.');
                    chars.add('.');
                }
            }
            list.add(chars);
        }

        this.list = list;
    }

    public List<List<Character>> getArea() {
        return list;
    }

    public void show() {
        for (List<Character> characters : list) {
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("####################################");
    }

    public int sumOfCoordinates() {
        int sum = 0;

        boolean isCounted = true;
        for (int i = 0; i < list.size(); i++) {
            List<Character> characters = list.get(i);
            for (int j = 0; j < characters.size(); j++) {
                Character character = characters.get(j);
                if (character.equals('|') && isCounted) {
                    sum += 100 * i + j;
                    isCounted = false;
                } else {
                    isCounted = true;
                }
            }
        }

        return sum;
    }

    void show(List<Pair>  list){
        for (Pair pair : list) {
            Character current = this.list.get(pair.r()).get(pair.c());
            System.out.print(current  + " ");
        }
        System.out.println();
    }


}
