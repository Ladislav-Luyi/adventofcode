package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Lights {
    List<List<Character>> current = new ArrayList<>();
    List<List<Character>> next = new ArrayList<>();

    public Lights(String s) {
        for (String row : s.split("\n")) {
            List<Character> list = Arrays.stream(row.split(""))
                    .map(s1 -> s1.charAt(0))
                    .collect(Collectors.toCollection(ArrayList::new));
            current.add(list);
        }

    }

    private static Character calculateLight(Character ch, long on) {
        Character r = null;
        if (ch.equals('#')) {
            if (on == 2L || on == 3L) {
                r = '#';
            } else {
                r = '.';
            }
        }
        if (ch.equals('.')) {
            if (on == 3L) {
                r = '#';
            } else {
                r = '.';
            }
        }
        return r;
    }

    private void setFixLights() {
        // top left
        current.get(0).set(0, '#');
        // top right
        current.get(0).set(current.get(0).size() - 1, '#');
        // bot left
        current.get(current.size() - 1).set(0, '#');
        // bot right
        current.get(current.size() - 1).set(current.get(current.size() - 1).size() - 1, '#');
    }

    void changeStateFixCornerLightsOn() {
        setFixLights(); // part2
        changeState();
        setFixLights(); // part2
    }

    void changeState() {
        next = new ArrayList<>();
        for (int i = 0; i < current.size(); i++) {
            List<Character> get = current.get(i);
            List<Character> inner = new ArrayList<>();
            for (int j = 0; j < get.size(); j++) {
                List<Character> neighbours = getNeighbours(i, j);
                Character currentChar = current.get(i).get(j);
//              System.out.println("light " + "row " + i + " column " + j + " "  +  current.get(i).get(j) + " neighbours: " + neighbours);
                long numberOfLightsOn = neighbours.stream().filter(character -> character.equals('#')).count();
                inner.add(calculateLight(currentChar, numberOfLightsOn));
            }
            next.add(inner);
        }
        current = next;
    }

    public long numberOfLightsOn() {
        return current.stream()
                .flatMap(Collection::stream)
                .filter(character -> character.equals('#'))
                .count();
    }


    private List<Character> getNeighbours(int r, int c) {
        List<Character> res = new ArrayList<>();
        //-r -c
        addCharToCol(res, r - 1, c - 1);
        // r -c
        addCharToCol(res, r, c - 1);
        // +r -c
        addCharToCol(res, r + 1, c - 1);
        // +r c
        addCharToCol(res, r + 1, c);
        // +r +c
        addCharToCol(res, r + 1, c + 1);
        // r +c
        addCharToCol(res, r, c + 1);
        // -r +c
        addCharToCol(res, r - 1, c + 1);
        // -r c
        addCharToCol(res, r - 1, c);
        return res;
    }

    private void addCharToCol(List<Character> col, int row, int column) {
        if (
                row >= 0 &&
                column >= 0 &&
                row < current.size() &&
                column < current.get(row).size()
        ) {
            col.add(current.get(row).get(column));
        }
    }
}
