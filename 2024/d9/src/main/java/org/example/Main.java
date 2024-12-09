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
        nodes = process1(nodes);
        System.out.println(parseToString(nodes));
//        List<String> newString = ;

//        System.out.println(nodes);
        List<String> strings1 = parseToString(nodes);
        System.out.println("final " + strings1);
        long sum = 0;
        int position = 0;
        for (String s : strings1) {
            if (s.equals(".")){
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
                System.out.println("match " + pollLast);
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

            System.out.println("step " + parseToString(nodes));
            Node last = nodes.peekLast();
            System.out.println(" processing last " + last);
            if (!last.isFile()){
                finish.add(nodes.pollLast());
                continue;
            }

            Node first = nodes.pollFirst();
            if (first.isFile()){
                tmp.add(first);
                continue;
            }
            System.out.println("comparing " + "first " + first + " last " + last);


            // there is place for last
            if (first.n() >= last.n()){
                int delta = first.n() - last.n();
                //finish left
                if (delta > 0) {
                    nodes.addFirst(new Node(false, ".", delta));
                }
//                last = nodes.pollLast();
                nodes.addFirst(nodes.pollLast());
                Collections.reverse(tmp);
                tmp.forEach(nodes::addFirst);
                tmp.clear();
                //finish right
                finish.add(new Node(false, ".", last.n()));

            }else {
                // there is not suitable space for last file
                tmp.add(first);
            }
        }

//        if (!tmp.isEmpty()){
//            Collections.reverse(tmp);
//            tmp.forEach(nodes::add);
//        }
//        System.out.println(finish);
        if (!finish.isEmpty()){
//                Collections.reverse(firstList);
            Collections.reverse(finish);
            finish.forEach(nodes::addLast);
        }
        System.out.println("finish " + finish);

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

    private static Deque<Node> compress(Deque<Node> input) {
        Deque<Node> nodes = new ArrayDeque<>();
        int lastCounter = 0;
        while(!input.isEmpty()){
            Node first = input.pollFirst();
            if (first.isFile()){
                nodes.add(first);
                continue;
            }
            Node peekNext = input.peekFirst();
            lastCounter+=first.n();
            if (Objects.isNull(peekNext) || peekNext.isFile()){
                if (lastCounter > 0){
                    nodes.add(new Node(false,".",lastCounter));
                    lastCounter = 0;
                }
            }

        }

        return nodes;

    }

    private static boolean isMoveAble( Deque<Node> nodes) {
        System.out.println(nodes);
        Deque<Node> copy = new ArrayDeque<>(nodes);
        if (!copy.peekLast().isFile()){
            copy.pollLast();
        }
        List<Node> list = new ArrayList<>(copy);
        boolean isMoveAble = false;
        for (int i = list.size() -1; i >=0; i--){
            Node last = list.get(i);
            if (!last.isFile()){
                continue;
            }
            for (int j = i - 1; j >=0; j--){
                Node next = list.get(j);
                if (next.isFile()){
                    continue;
                }
                if (last.n() <= next.n()){
                    return true;
                }
            }
        }

        return isMoveAble;
    }

    private static Deque<Node> process(Deque<Node> nodes) {
        List<Node> lastNodes = new ArrayList<>();
        Deque<Node> finalString = new ArrayDeque<>();
        while(!nodes.isEmpty()){
            Node first = nodes.peekFirst();
            Node last = nodes.peekLast();
            if (first.isFile()){
                finalString.add(nodes.pollFirst());
                continue;
            }

            if (first.n() < last.n()){
                lastNodes.add(nodes.pollLast());
                continue;
            }
            // TODO do I have to handle what happens with last .??
            first = nodes.pollFirst();
            if (first == last){
                finalString.add(first);
                continue;
            }
            last = nodes.pollLast();
            lastNodes.add(new Node(false, ".", last.n()));
            int deltaDots = first.n() - last.n();
            finalString.add(last);
            if (deltaDots > 0) {
                nodes.addFirst(new Node(false, ".", deltaDots));
            }
        }

//        System.out.println("final string before " + finalString);
        Collections.reverse(lastNodes);

        finalString.addAll(lastNodes);
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
                boolean isNotFile = previous.equals(".") ? false : true;
                nodes.add(new Node(isNotFile,previous, lastCounter));
                lastCounter = 1;
            }else {
                lastCounter++;
            }
            if (i == strings.size() - 1){
                boolean isFile = previous.equals(".") ? false : true;
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