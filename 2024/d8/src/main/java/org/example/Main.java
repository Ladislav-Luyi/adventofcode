package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<ArrayList<Character>> list = loadFile("test")
                .stream().map(Main::parseLine)
                .toList();
        Map<Character, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Character> characters = list.get(i);
            for (int j = 0; j < characters.size(); j++) {
                Character character = characters.get(j);
                if (character.equals('.')) {
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
        part1(map, list);
        part2(map, list);

    }

    private static void part2(Map<Character, List<Pair>> map, List<ArrayList<Character>> list) {
        Set<Pair> pairs = new HashSet<>();
        for (Map.Entry<Character, List<Pair>> characterSetEntry : map.entrySet()) {
            Character key = characterSetEntry.getKey();
            if (key.equals('#') ){
                continue;
            }

            List<Pair> value = characterSetEntry.getValue();
            for (int i = 0; i < value.size() - 1; i++) {
                Pair pair1 = value.get(i);
                for (int j = i + 1; j < value.size(); j++) {
                    Pair pair2 = value.get(j);
                    pairs.add(pair1);
                    pairs.add(pair2);
                    Pair loopPair1 = pair1;
                    Pair loopPair2 = pair2;
                    while(true) {
                        Pair nextPair1 = calculateNextPair(loopPair1, loopPair2);
                        if (isValidAntiNode(nextPair1, list)) {
                            pairs.add(nextPair1);
                            loopPair2 = loopPair1;
                            loopPair1 = nextPair1;
                        }else{
                            break;
                        }
                    }
                    loopPair1 = pair2;
                    loopPair2 = pair1;
                    while(true) {
                        Pair nextPair2 = calculateNextPair(loopPair1, loopPair2);
                        if (isValidAntiNode(nextPair2, list)) {
                            pairs.add(nextPair2);
                            loopPair2 = loopPair1;
                            loopPair1 = nextPair2;
                        }else{
                            break;
                        }
                    }
                }
            }


        }
        System.out.println(pairs.size());

    }

    private static void part1(Map<Character, List<Pair>> map, List<ArrayList<Character>> list) {
        Set<Pair> pairs = new HashSet<>();
        for (Map.Entry<Character, List<Pair>> characterSetEntry : map.entrySet()) {
            List<Pair> value = characterSetEntry.getValue();
            for (int i = 0; i < value.size() - 1; i++) {
                Pair pair1 = value.get(i);
                for (int j = i + 1; j < value.size(); j++) {
                    Pair pair2 = value.get(j);
                    Pair nextPair1 = calculateNextPair(pair1, pair2);
                    if (isValidAntiNode(nextPair1, list))
                    {
                        pairs.add(nextPair1);
                    }
                    Pair nextPair2 = calculateNextPair(pair2, pair1);
                    if (isValidAntiNode(nextPair2, list))
                    {
                        pairs.add(nextPair2);
                    }
                }
            }


        }
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


}