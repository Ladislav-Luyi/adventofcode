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
        part1(parsed);


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