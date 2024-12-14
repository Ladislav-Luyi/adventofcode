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
//        Pair area = new Pair(7,11);
//        Pair dir = new Pair(-3,2);
//        Pair location  = new Pair(4,2);
//        Robot robot = new Robot(location, dir, area);



        List<String> strings = loadFile("input");
        List<Robot> robots = new ArrayList<>();
        Pattern p = Pattern.compile("p=(-?\\w+),(-?\\w+) v=(-?\\w+),(-?\\w+)");
        Pair area = new Pair(103,101);
        for (String string : strings) {
            Matcher m = p.matcher(string);
            m.find();
            Pair dir = new Pair(Integer.parseInt( m.group(4)),Integer.parseInt( m.group(3)));
            Pair location  = new Pair(Integer.parseInt( m.group(2)),Integer.parseInt( m.group(1)));
            robots.add(new Robot(location, dir, area));
        }
        robots.forEach(e -> System.out.println(e.getQuadrant()) );

        for (int i = 0; i < 100; i++){
            robots.forEach(Robot::move);
            showStatus(area, robots);
        }


//        robots.forEach(System.out::println);

        HashMap<Integer, Integer> map = new HashMap<>();
        robots.stream()
                .filter(e -> e.getQuadrant() != -1)
                .forEach( e -> map.merge(e.getQuadrant(), 1, Integer::sum));
        int sum = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
            sum *= entry.getValue();
        }
        System.out.println(map);
        System.out.println(sum);

    }

    private static void showStatus(Pair area, List<Robot> robots) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < area.x(); i++){
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < area.y(); j++){
                inner.add(0);
            }
            lists.add(inner);
        }


        for (Robot robot : robots) {
            Pair location = robot.location;
            Integer i = lists.get(location.x()).get(location.y());
            lists.get(location.x()).set(location.y(), ++i);
        }
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("#######################");
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