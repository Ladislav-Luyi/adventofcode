package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Pair> test = loadFile("input")
                .stream().map(
                        Main::parseToPair
                )
//                .peek(System.out::println)
                .toList();
//        part1(test);
        part2(test);

    }


    private static void part1(List<Pair> test) {
        Long result = test.stream()
                .filter(e -> combination1(e, new ArrayList<>(), 0, new ArrayList<>()))
                .peek(System.out::println)
                .map(Pair::result)
                .reduce(Long::sum)
                .orElseThrow();
        System.out.println(result);
    }

    private static void part2(List<Pair> test) {
        Long result = test.stream()
                .filter(e -> combination2(e, new ArrayList<>(), 0, new ArrayList<>()))
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

    static boolean combination1(
            Pair pair,
            List<Long> tmp,
            int i,
            List<Operator> operators
    ) {
        Long sum = 0L;
        if (tmp.size() == pair.arguments().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < tmp.size(); j++) {
                Long l = tmp.get(j);
                if (Objects.isNull(operators)) {
                    sum = 0L;
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
            combination1 = combination1(pair, tmp, j + 1, operators);
            if (combination1) {
                return true;
            }
            operators.remove(operators.size() - 1);
            operators.add(Operator.MULTIPLICATION);
            combination1 = combination1(pair, tmp, j + 1, operators);
            if (combination1) {
                return true;
            }
            operators.remove(operators.size() - 1);
            tmp.remove(tmp.size() - 1);
        }
        return combination1;
    }

    static boolean combination2(
            Pair pair,
            List<Long> tmp,
            int i,
            List<Operator> operators
    ) {
        Long sum = 0L;
        if (tmp.size() == pair.arguments().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < tmp.size(); j++) {
                Long l = tmp.get(j);
                if (Objects.isNull(operators)) {
                    sum = 0L;
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
                if (operator.equals(Operator.CONCAT)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sum);
                    sb.append(l);
                    sum = Long.valueOf(sb.toString());
                    stringBuilder.append(" || " + l);
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
            // plus
            operators.add(Operator.PLUS);
            combination1 = combination2(pair, tmp, j + 1, operators);
            if (combination1) {
                return true;
            }
            operators.remove(operators.size() - 1);
            // MULTIPLICATION
            operators.add(Operator.MULTIPLICATION);
            combination1 = combination2(pair, tmp, j + 1, operators);
            if (combination1) {
                return true;
            }
            operators.remove(operators.size() - 1);
            // concat
            operators.add(Operator.CONCAT);
            combination1 = combination2(pair, tmp, j + 1, operators);
            if (combination1) {
                return true;
            }
            operators.remove(operators.size() - 1);

            tmp.remove(tmp.size() - 1);
        }
        return combination1;
    }

    enum Operator {
        MULTIPLICATION, PLUS, CONCAT
    }
}


