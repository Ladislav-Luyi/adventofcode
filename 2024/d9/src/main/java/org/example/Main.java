package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String> lines = loadFile("test");
        List<String> parsed = new ArrayList<>();
        for (String line : lines) {
            for (String s : line.split("")) {
                parsed.add(s);

            }
        }
        part2(parsed);


    }


    private static void part2(List<String> parsed) {
        List<String> strings = new ArrayList<>();
        int fileCounter = 0;
        Integer idCounter = 0;

        for (String s : parsed) {
            int n = Integer.parseInt(s);
            if (fileCounter % 2 == 0){
                for (int i = 0; i<n;i++){
                    strings.add(idCounter.toString());
                }
                idCounter++;
            }else {
                for (int i = 0; i<n;i++){
                    strings.add(".");
                }
            }
            fileCounter++;
        }
        System.out.println(strings);
        Deque<Node> nodes = compress(strings);

        System.out.println(nodes);

        Deque<Node> finalString = process(nodes);

        System.out.println(finalString);


    }

    private static Deque<Node> process(Deque<Node> nodes) {
        int emptySpaceCounter = 0;
        Deque<Node> finalString = new ArrayDeque<>();
        while(!nodes.isEmpty()){
            Node first = nodes.pollFirst();
            if (first.isFile()){
                finalString.add(first);
                continue;
            }
            Node last = nodes.peekLast();
            System.out.println(last);
            if (Objects.isNull(last)) {
                finalString.add(first);
                continue;
            }

            if (first.n() < last.n()){
                finalString.add(first);
                continue;
            }
            last = nodes.pollLast();
            emptySpaceCounter+=last.n();
            int deltaDots = first.n() - last.n();
            finalString.add(last);
            if (deltaDots > 0) {
                finalString.add(new Node(false, ".", deltaDots));
            }
        }
        if (emptySpaceCounter > 0) {
            finalString.add(new Node(false, ".", emptySpaceCounter));
        }
        return finalString;
    }

    private static Deque<Node> compress(List<String> strings) {
        int lastCounter = 1;
        Deque<Node> nodes = new ArrayDeque<>();
        for (int i = 1; i < strings.size(); i++) {
            String previous = strings.get(i - 1);
            String current = strings.get(i);
//            System.out.println("previous " + previous + " current " + current);
            if (!previous.equals(current)){
                boolean isFile = ! current.equals(".") ? false : true;
                nodes.add(new Node(isFile,previous, lastCounter));
                lastCounter = 1;
            }else {
                lastCounter++;
            }
            if (i == strings.size() - 1){
                boolean isFile = ! current.equals(".") ? false : true;
                nodes.add(new Node(isFile,previous, lastCounter));
            }
        }
        return nodes;
    }


    private static void part1(List<String> parsed) {
        Deque<String> strings = new ArrayDeque<>();
        int fileCounter = 0;
        Integer idCounter = 0;

        for (String s : parsed) {
            int n = Integer.parseInt(s);
            if (fileCounter % 2 == 0){
                for (int i = 0; i<n;i++){
                    strings.add(idCounter.toString());
                }
                idCounter++;
            }else {
                for (int i = 0; i<n;i++){
                    strings.add(".");
                }
            }
            fileCounter++;
        }
        int emptySpaceCounter = 0;
        ArrayList<String> finalString = new ArrayList<>();
        while(!strings.isEmpty()){
            String first = strings.pollFirst();
            if (!first.equals(".")){
                finalString.add(first);
                continue;
            }
            emptySpaceCounter++;

            while(true) {
                String last = strings.pollLast();
                if (Objects.isNull(last)){
                    break;
                }
                if (last.equals(".")) {
                    emptySpaceCounter++;
                }else {
                    finalString.add(last);
                    break;
                }
            }
        }
        for (int i = 0; i < emptySpaceCounter; i++){
            finalString.add(".");
        }
        long sum = 0;
        int position = 0;
        for (String s : finalString) {
            if (s.equals(".")){
                continue;
            }
            long i = Long.parseLong(s);
            sum += i * position;
            position++;
        }

        System.out.println(sum);
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