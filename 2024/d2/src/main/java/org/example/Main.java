package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String input = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
            """;

    public static void main(String[] args) {


        List<List<Integer>> lists = new ArrayList<>();
        for (String e : input.split("\n")) {
            List<Integer> list = new ArrayList<>();
            for (String s : e.split(" ")) {
                list.add(Integer.valueOf(s));
            }
            lists.add(list);
        }

        long count = lists.stream()
                .map(e -> new LevelValidator(1,3).validateLevels(e))
                .peek(System.out::println)
                .filter(Report::isSafe)
                .count();
        System.out.println(count);


    }



}