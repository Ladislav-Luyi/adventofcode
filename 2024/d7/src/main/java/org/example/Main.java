package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Pair> test = loadFile("test")
                .stream().map(
                        Main::parseToPair
                )
//                .peek(System.out::println)
                .toList();
//        part1(test);
        part2(test);

    }

    static Set<Long> set = new HashSet<>();
    private static void part2(List<Pair> test) {
        System.out.println(test);
        ArrayList<Pair> pairs = new ArrayList<>();
        for (Pair pair : test) {
            set.clear();
            if (combination(pair, new ArrayList<>(), 0, new ArrayList<>())){
                pairs.add(pair);
            }else {
                if (pair.arguments().size() == 2 && concatToLong(pair.arguments()).equals(pair.result())){
                    System.out.println("adding pair " + pair);
                    pairs.add(pair);
                }
                assignCombinations(pair, new ArrayList<>(), 0, new ArrayList<>());
            }
            System.out.println(set);
        }


        Long result = pairs.stream()
                .map(Pair::result)
                .reduce(Long::sum)
                .orElseThrow();
        System.out.println(result);
    }

    private static Long concatToLong(List<Long> arguments) {
        StringBuilder stringBuilder = new StringBuilder();
        arguments.forEach(stringBuilder::append);
        return Long.parseLong(stringBuilder.toString());
    }

    private static void part1(List<Pair> test) {
        Long result = test.stream()
                .filter(e -> combination(e, new ArrayList<>(), 0, new ArrayList<>()))
                .peek(System.out::println)
                .map(Pair::result)
                .reduce(Long::sum)
                .orElseThrow();
        System.out.println(result);
    }

    private static Pair parseToPair(String s) {
        String[] split = s.split(":");
        long result = Long.parseLong(split[0]);
        List<Long> ints = new ArrayList<>();
        Stream.of(split[1].split(" +"))
                .skip(1)
                .forEach(e -> ints.add(Long.valueOf(e)));
        return new Pair(result, ints);
    }

    public static List<String> loadFile(String filename) {
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

    static void assignCombinations(
            Pair pair,
            List<Long> longs,
            int i,
            List<Operator> operators
    ) {
        Long sum = 0l;
        if (longs.size() == pair.arguments().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < longs.size(); j++) {
                Long l = longs.get(j);
                if (Objects.isNull(operators)) {
                    sum = 0l;
                    break;
                }
                if (j == 0) {
                    sum = l;
                    stringBuilder.append(l + " ");
                    continue;
                }
                Operator operator = operators.get(j);
                if (operator.equals(Operator.PLUS)) {
                    sum += l;
                    stringBuilder.append(" + " + l);
                }
                if (operator.equals(Operator.MULTIPLICATION)) {
                    sum *= l;
                    stringBuilder.append(" * " + l);
                }
            }
            stringBuilder.append(" = " + sum);
//            System.out.println(stringBuilder);
        }

        if (longs.size() == pair.arguments().size()) {
            set.add(sum);
            return;
        }
        for (int j = i; j < pair.arguments().size(); j++) {
            Long get = pair.arguments().get(j);
            longs.add(get);
            operators.add(Operator.PLUS);
            assignCombinations(pair, longs, j + 1, operators);
            operators.remove(operators.size() -1);
            operators.add(Operator.MULTIPLICATION);
            assignCombinations(pair, longs, j + 1, operators);
            operators.remove(operators.size() -1);
            longs.remove(longs.size() -1 );
        }
    }

    static boolean combination(
            Pair pair,
            List<Long> tmp,
            int i,
            List<Operator> operators
    ) {
        Long sum = 0l;
        if (tmp.size() == pair.arguments().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < tmp.size(); j++) {
                Long l = tmp.get(j);
                if (Objects.isNull(operators)) {
                    sum = 0l;
                    break;
                }
                if (j == 0) {
                    sum = l;
                    stringBuilder.append(l + " ");
                    continue;
                }
                Operator operator = operators.get(j);
                if (operator.equals(Operator.PLUS)) {
                    sum += l;
                    stringBuilder.append(" + " + l);
                }
                if (operator.equals(Operator.MULTIPLICATION)) {
                    sum *= l;
                    stringBuilder.append(" * " + l);
                }
            }
            stringBuilder.append(" = " + sum);
//            System.out.println(stringBuilder);
        }
        if (sum > pair.result()) {
            return false;
        }

        if (sum.equals(pair.result()) && tmp.size() == pair.arguments().size()) {
            return true;
        }
        boolean combination1 = false;
        for (int j = i; j < pair.arguments().size(); j++) {
            Long get = pair.arguments().get(j);
            tmp.add(get);
            operators.add(Operator.PLUS);
            combination1 = combination(pair, tmp, j + 1, operators);
            if (combination1 == true){
                return true;
            }
            operators.remove(operators.size() -1);
            operators.add(Operator.MULTIPLICATION);
            combination1 = combination(pair, tmp, j + 1, operators);
            if (combination1 == true){
                return true;
            }
            operators.remove(operators.size() -1);
            tmp.remove(tmp.size() -1 );
        }
        return combination1;
    }

    enum Operator{
        MULTIPLICATION, PLUS
    }
}


