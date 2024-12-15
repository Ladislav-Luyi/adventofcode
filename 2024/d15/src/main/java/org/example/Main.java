package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Main {
    public static void main(String[] args) {
//        Area1 area1 = new Area1(loadFile("area"));
//        Queue<Character> queue = new ArrayDeque<>();
//        for (String lines : loadFile("directions")) {
//            for (String s : lines.split("")) {
//                queue.add(s.charAt(0));
//            }
//        }
//        RobotCrawler1 robotCrawler1 = new RobotCrawler1(area1, queue);
//        robotCrawler1.run();
//        System.out.println(area1.sumOfCoordinates());

        Area3 area3 =  new Area3(loadFile("area"));
        Queue<Character> queue = new ArrayDeque<>();
        for (String lines : loadFile("directions")) {
            for (String s : lines.split("")) {
                queue.add(s.charAt(0));
            }
        }
        RobotCrawler3 robotCrawler3 = new RobotCrawler3(area3, queue);
        robotCrawler3.run();
        System.out.println(area3.sumOfCoordinates());


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