package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1248724126354 too low
        // 1248732023747 too low
        // 1248732023747
        List<Pair> test = loadFile("input")
                .stream().map(
                        Main::parseToPair
                )
//                .peek(System.out::println)
                .toList();
        test.forEach(e -> combination(e, new ArrayList<>(), 0, new ArrayList<>()));
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
            // TODO is this correct??
            tmp.remove(tmp.size() -1 );
        }
        return combination1;
    }

    enum Operator{
        MULTIPLICATION, PLUS
    }
}


