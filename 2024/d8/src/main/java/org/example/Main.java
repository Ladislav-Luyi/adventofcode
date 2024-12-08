package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<ArrayList<Character>> list = loadFile("test")
                .stream().map(e -> {
                    return parseLine(e);
                })
                .toList();
        System.out.println(list);
        Map<Character, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Character> characters = list.get(i);
            for (int j = 0; j < characters.size(); j++) {
                Character character = characters.get(j);
                if (character.equals('.') || character.equals('#')) {
                    continue;
                }
                Pair pair = new Pair(i, j);
                List<Pair> l = new ArrayList<>();
                l.add(pair);
                map.merge(character, l, (pairs, pairs2) -> {
                    pairs.addAll(pairs2);
                    return pairs;
                });
            }
        }
        Set<Pair> pairs = new HashSet<>();
        for (Map.Entry<Character, List<Pair>> characterSetEntry : map.entrySet()) {
            List<Pair> value = characterSetEntry.getValue();
            for (int i = 0; i < value.size() - 1; i++) {
                Pair pair1 = value.get(i);
                for (int j = i + 1; j < value.size(); j++) {
                    Pair pair2 = value.get(j);
                    System.out.println(pair1 + " " + pair2);
                    // calculate antinode for pair1
                    Pair nextPair1 = calculateNextPair(pair1, pair2);
                    // valid

                    if (isValidAntiNode(nextPair1, list))
                    {
                        pairs.add(nextPair1);
                    }
                    // calculate antinode for pair2
                    Pair nextPair2 = calculateNextPair(pair2, pair1);
                    // valid
                    if (isValidAntiNode(nextPair2, list))
                    {
                        pairs.add(nextPair2);
                    }
                }
            }


        }
        System.out.println(pairs);
        System.out.println(pairs.size());

    }

    private static boolean isValidAntiNode(Pair nextPair1, List<ArrayList<Character>> list) {
        try {
            list.get(nextPair1.r()).get(nextPair1.c());
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private static Pair calculateNextPair(Pair pair1, Pair pair2) {
        int nextRow = pair1.r() - pair2.r();
        int nextCol = pair1.c() - pair2.c();
        return new Pair(pair1.r() + nextRow, pair1.c() + nextCol);
    }


    private static ArrayList<Character> parseLine(String s) {
        ArrayList<Character> characters = new ArrayList<>();

        Stream.of(s.split(""))
                .forEach(e -> {
//                    HashSet hashSet = new HashSet<>();
//                    hashSet.add(e);
                    characters.add(e.charAt(0));
                });
        return characters;
    }

    public static List<String> loadFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(filename);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            for (String line; (line = reader.readLine()) != null; ) {
                lines.add(line);
            }

        } catch (FileNotFoundException fnfe) {
            // process errors
        } catch (IOException ioe) {
            // process errors
        }
        return lines;
    }


//    private static List<String> createWordFromRange(int i, int j, int n) {
//        ArrayList<String> r = new ArrayList<>();
//        for (Directions value : Directions.values()) {
//            createWordFromRange(value, i, j,0, n, new StringBuilder(), r);
//        }
//        return r;
//    }
//
//    private static void createWordFromRange(Directions direction,
//                                            int i,
//                                            int j,
//                                            int steps,
//                                            int n,
//                                            StringBuilder stringBuilder,
//                                            List<String> result) {
//        if (steps == n){
//            result.add(stringBuilder.toString());
//            return;
//        }
//
//        try {
//            stringBuilder.append(listList.get(i).get(j));
//        } catch (IndexOutOfBoundsException e){
//            return;
//        }
//
//        if (direction.equals(Directions.RIGHT)) {
//            createWordFromRange(direction, i, j + 1, steps + 1, n, stringBuilder, result);
//        } else if (direction.equals(Directions.DIAGONAL_DOWN_RIGHT)) {
//            createWordFromRange(direction, i + 1, j + 1, steps + 1, n, stringBuilder, result);
//        }else if (direction.equals(Directions.DOWN)) {
//            createWordFromRange(direction, i + 1, j, steps + 1, n, stringBuilder, result);
//        }else if (direction.equals(Directions.DIAGONAL_DOWN_LEFT)) {
//            createWordFromRange(direction, i + 1, j - 1, steps + 1, n, stringBuilder, result);
//        }else if (direction.equals(Directions.LEFT)) {
//            createWordFromRange(direction, i, j - 1, steps + 1, n, stringBuilder, result);
//        }else if (direction.equals(Directions.DIAGONAL_UP_LEFT)) {
//            createWordFromRange(direction, i - 1, j - 1, steps + 1, n, stringBuilder, result);
//        }else if (direction.equals(Directions.UP)) {
//            createWordFromRange(direction, i - 1, j, steps + 1, n, stringBuilder, result);
//        }else if (direction.equals(Directions.DIAGONAL_UP_RIGHT)) {
//            createWordFromRange(direction, i - 1, j + 1, steps + 1, n, stringBuilder, result);
//        }
//    }
//
//    private static Set<String> prepareWordList(String s) {
//        Set<String> wordList = new HashSet<>();
//        wordList.add(searchFor);
////        wordList.add(new StringBuffer(searchFor).reverse().toString());
//        return wordList;
//    }
//
//    private static List<List<Character>> parseInput(String input) {
//        List<List<Character>> listList = new ArrayList<>();
//        for (String s : input.split("\n")) {
//            ArrayList<Character> inner = new ArrayList<>();
//            for (String string : s.split("")) {
//                inner.add(string.charAt(0) );
//            }
//            listList.add(inner);
//        }
//        return listList;
//    }

//    static void show(List<List<Character>> listList){
//        for (List<Character> list : listList) {
//            for (Character c : list) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
//
//    }
//
//    enum Directions{
//
//        RIGHT,
//        DIAGONAL_DOWN_RIGHT,
//        DOWN,
//        DIAGONAL_DOWN_LEFT,
//        LEFT,
//        DIAGONAL_UP_LEFT,
//        UP,
//        DIAGONAL_UP_RIGHT
//    }
}