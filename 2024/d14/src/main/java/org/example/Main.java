package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {

        List<String> strings = loadFile("input");
        List<Robot> robots = new ArrayList<>();
        Pattern p = Pattern.compile("p=(-?\\w+),(-?\\w+) v=(-?\\w+),(-?\\w+)");
        Pair area = new Pair(103, 101);
        for (String string : strings) {
            Matcher m = p.matcher(string);
            m.find();
            Pair dir = new Pair(Integer.parseInt(m.group(4)), Integer.parseInt(m.group(3)));
            Pair location = new Pair(Integer.parseInt(m.group(2)), Integer.parseInt(m.group(1)));
            robots.add(new Robot(location, dir, area));
        }

        for (int i = 0; i < 20000; i++) {
            robots.forEach(Robot::move);
            showStatus(area, robots, i);
        }


        HashMap<Integer, Integer> map = new HashMap<>();
        robots.stream()
                .filter(e -> e.getQuadrant() != -1)
                .forEach(e -> map.merge(e.getQuadrant(), 1, Integer::sum));
        int sum = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
            sum *= entry.getValue();
        }
        System.out.println(map);
        System.out.println(sum);

    }

    private static void showStatus(Pair area, List<Robot> robots, int count) {

        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < area.x(); i++) {
            List<String> inner = new ArrayList<>();
            for (int j = 0; j < area.y(); j++) {
                inner.add(".");
            }
            lists.add(inner);
        }


        for (Robot robot : robots) {
            Pair location = robot.location;
            lists.get(location.x()).set(location.y(), "O");
        }
        // are next to each other 10 or more
        boolean isTree = false;
        int treeCount = 0;
        for (List<String> list : lists) {
            for (String i : list) {
                if (i.equals("O")) {
                    treeCount++;
                } else {
                    treeCount = 0;
                }
                if (treeCount >= 10) {
                    isTree = true;
                }
            }
        }
        if (isTree) {
            System.out.println("####################### " + count);
            for (List<String> list : lists) {
                for (String i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println("#######################");
        }

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