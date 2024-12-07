package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        List<Pair> test = loadFile("test")
                .stream().map(
                        Main::parseToPair
                )
                .peek(System.out::println)
                .toList();
        test.forEach(e -> combination(e, new ArrayList<>(), 0, null));
        System.out.println(list);


    }

    private static Pair parseToPair(String s) {
        String[] split = s.split(":");
        int result = Integer.parseInt(split[0]);
        List<Integer> ints = new ArrayList<>();
        Stream.of(split[1].split(" +"))
                .skip(1)
                .forEach(e -> ints.add(Integer.valueOf(e)));
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

    static void combination(
            Pair pair,
            List<Integer> tmp,
            int i,
            Operator operator
    ) {
        Integer sum = 0;
        if (tmp.size() == pair.arguments().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < tmp.size(); j++) {
                Integer integer = tmp.get(j);
                if (Objects.isNull(operator)) {
                    sum = 0;
                    break;
                }
                if (j == 0) {
                    sum = integer;
                    stringBuilder.append(integer + " ");
                    continue;
                }
                if (operator.equals(Operator.PLUS)) {
                    sum += integer;
                    stringBuilder.append(" + " + integer);
                }
                if (operator.equals(Operator.MULTIPLICATION)) {
                    sum *= integer;
                    stringBuilder.append(" * " + integer);
                }
            }
            stringBuilder.append(" = " + sum);
            System.out.println(stringBuilder);
        }
        if (sum > pair.result()) {
            return;
        }

        if (sum.equals(pair.result()) && tmp.size() == pair.arguments().size()) {
//            listList.add(new ArrayList<>(tmp));
            list.add(sum);
            return;
        }
        for (int j = i; j < pair.arguments().size(); j++) {
            Integer get = pair.arguments().get(j);
            tmp.add(get);
            combination(pair, tmp, j + 1, Operator.PLUS);
            combination(pair, tmp, j + 1, Operator.MULTIPLICATION);
            tmp.remove(get);
        }
    }

    enum Operator{
        MULTIPLICATION, PLUS
    }
}


