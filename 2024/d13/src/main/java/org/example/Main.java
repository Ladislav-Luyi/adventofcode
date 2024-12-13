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
//                // partB
//                machines.add(new Machine(a, b, toBiggerr(toPair(s))));
                // partA
                machines.add(new Machine(a, b, toPair(s)));
            }
        }
        System.out.println(machines);


        Long sum = machines.stream()
                .map(MachineOptimizer::new)
                .map(MachineOptimizer::getResult)
                .filter(Result::winAble)
                .peek(System.out::println)
                .map(Result::tokens)
                .reduce(Long::sum)
                .orElseThrow();

        System.out.println(sum);

    }

    private static Pair toBiggerr(Pair pair) {
        Long x = pair.x();
        Long y = pair.y();
        String s = "10000000000000";
        x.toString().length();

        String substring = s.substring(0,s.length() - x.toString().length());
        Long newX = Long.valueOf(  substring + x );
        substring = s.substring(0,s.length() - y.toString().length());
        Long newY= Long.valueOf(  substring + y );

        return new Pair(newX, newY);
    }

    private static Pair toPair(String s) {
        // Button A: X+94, Y+34
        String s1 = s.split(":")[1];
        String[] pairS = s1.split(",");
        return new Pair
                (
                        Long.parseLong(
                                pairS[0]
                                        .replaceAll("\\s+", "")
                                        .replace("X=", "")
                                        .replace("X+", "")),
                        Long.parseLong(
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