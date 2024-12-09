package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> lines = loadFile("test");
        List<String> parsed = new ArrayList<>();
        for (String line : lines) {
            for (String s : line.split("")) {
                parsed.add(s);

            }
        }
        part1(parsed);
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

        Deque<Node> nodes = compress(strings);
        nodes = process1(nodes);
        List<String> strings1 = parseToString(nodes);
        long sum = 0;
        int position = 0;
        for (String s : strings1) {
            if (s.equals(".")){
                position++;
                continue;
            }
            long i = Long.parseLong(s);
            sum += i * position;
            position++;
        }

        System.out.println(sum);

    }

    private static Deque<Node> process1(Deque<Node> nodes) {
        List<Node> tmp = new ArrayList<>();
        List<Node> finish = new ArrayList<>();

        while(!nodes.isEmpty()){
            // there is not suitable space for last file and all spaces where checked
            if (!tmp.isEmpty() && nodes.size() == 1){
                Node pollLast = nodes.pollLast();
                finish.add(pollLast);
                Collections.reverse(tmp);
                tmp.forEach(nodes::addFirst);
                tmp.clear();
                continue;
            }

            if (tmp.isEmpty() && nodes.size() == 1){
                Node pollLast = nodes.pollLast();
                finish.add(pollLast);
                continue;
            }

//            System.out.println("step " + parseToString(nodes));
            Node last = nodes.peekLast();
            if (!last.isFile()){
                finish.add(nodes.pollLast());
                continue;
            }

            Node first = nodes.pollFirst();
            if (first.isFile()){
                tmp.add(first);
                continue;
            }
            // there is place for last
            if (first.n() >= last.n()){
                int delta = first.n() - last.n();
                //finish left
                if (delta > 0) {
                    nodes.addFirst(new Node(false, ".", delta,0));
                }
//                last = nodes.pollLast();
                nodes.addFirst(nodes.pollLast());
                Collections.reverse(tmp);
                tmp.forEach(nodes::addFirst);
                tmp.clear();
                //finish right
                finish.add(new Node(false, ".", last.n(),0));

            }else {
                // there is not suitable space for last file
                tmp.add(first);
            }
        }

        if (!finish.isEmpty()){
            Collections.reverse(finish);
            finish.forEach(nodes::addLast);
        }

        return nodes;
    }

    private static List<String> parseToString(Deque<Node> nodes) {
        List<String> list = new ArrayList<>();
        for (Node node : new ArrayList<>(nodes)) {
            for (int i = 0; i < node.n(); i++){
                list.add(node.s());
            }
        }
        return list;
    }


    private static Deque<Node> compress(List<String> strings) {
        int lastCounter = 1;
        Deque<Node> nodes = new ArrayDeque<>();
        int idCounter = 0;
        for (int i = 1; i < strings.size(); i++) {
            String previous = strings.get(i - 1);
            String current = strings.get(i);
            if (!previous.equals(current)){
                boolean isNotFile = previous.equals(".") ? false : true;
                if (!isNotFile) {
                    nodes.add(new Node(isNotFile, previous, lastCounter,0));
                }else {
                    nodes.add(new Node(isNotFile, previous, lastCounter,idCounter++));
                }
                lastCounter = 1;
            }else {
                lastCounter++;
            }
            if (i == strings.size() - 1){
                boolean isNotFile = previous.equals(".") ? false : true;
                if (!isNotFile) {
                    nodes.add(new Node(isNotFile, previous, lastCounter,0));
                }else{
                    nodes.add(new Node(isNotFile, previous, lastCounter,idCounter++));
                }
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