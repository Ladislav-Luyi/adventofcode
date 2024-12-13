package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> strings = loadFile("input");
        Pair a = null;
        Pair b = null;
        List<Machine> machines = new ArrayList<>();
        for (String s : strings) {
            if (s.matches(".*A:.*")) {
                a = toPair(s);
            }
            if (s.matches(".*B:.*")) {
                b = toPair(s);
            }
            if (s.matches(".*Prize:.*")) {

                machines.add(new Machine(a, b, toPair(s)));
            }
        }
        System.out.println(machines);

//        for (int i = 0; i < 80; i ++) {
//            machines.get(0).pushA();
//        }
//
//        for (int i = 0; i < 40; i ++) {
//            System.out.println( machines.get(0).pushB());
//        }
//        System.out.println(machines.get(0).getTokenPrice());


        Integer sum = machines.stream()
                .map(MachineOptimizer::new)
                .map(MachineOptimizer::getResult)
                .filter(Result::winAble)
                .peek(System.out::println)
                .map(Result::tokens)
                .reduce(Integer::sum)
                .orElseThrow();

        System.out.println(sum);

    }

    private static Pair toPair(String s) {
        // Button A: X+94, Y+34
        String s1 = s.split(":")[1];
        String[] pairS = s1.split(",");
        return new Pair
                (
                        Integer.parseInt(
                                pairS[0]
                                        .replaceAll("\\s+", "")
                                        .replace("X=", "")
                                        .replace("X+", "")),
                        Integer.parseInt(
                                pairS[1]
                                        .replaceAll("\\s+", "")
                                        .replace("Y=", "")
                                        .replace("Y+", ""))


                );

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