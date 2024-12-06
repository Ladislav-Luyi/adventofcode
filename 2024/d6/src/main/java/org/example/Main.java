package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<List<Character>> list = new ArrayList<>();
    static ArrayList<String> strings = loadFile("test1");

    private static  List<List<Character>> parseToList() {
        // 1598 too low 1599 too low 1600
        List<List<Character>> list = new ArrayList<>();
        for (String string : strings) {
            ArrayList<Character> objects = new ArrayList<>();
            for (String s : string.split("")) {
                objects.add(s.charAt(0));
            }
            list.add(objects);
        }
        return list;
    }


    public static void main(String[] args) {
        part1();
//        System.out.println( new Guard(list).countSteps());
//        part2();
    }

    private static void part2() {
        list = parseToList();
        int loops = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Character> characters = list.get(i);
            for (int j = 0; j < characters.size(); j++) {
//                System.out.println("next tile " + i + " " + j);
                Character character = characters.get(j);
                if (list.get(i).get(j) == '^' || list.get(i).get(j) == '#') {
                    list = parseToList(); // TODO is this needed?
                    continue;
                }
                list.get(i).set(j, '#');
                // main
                try {
                    Guard guard = new Guard(list);
//                    guard.show();
                    guard.countSteps();
                } catch (LoopException e) {
//                    System.out.println("loop exception");
                    loops++;
                }
                // switch back
//                list.get(i).set(j, '.');
                list = parseToList();
            }
        }
        System.out.println(loops);
    }


    private static void part1() {
        list = parseToList();
        Guard guard = new Guard(list);
        guard.show();
        System.out.println(guard.countSteps());
        System.out.println(guard.countDistinctPositions());
    }

    static public ArrayList<String> loadFile(String filename) {
        ArrayList<String> lines = new ArrayList<String>();

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