package org.example;

import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        List<String> strings = FileHelper.readFileAsList("C:\\Users\\A51184456\\OneDrive - Deutsche Telekom AG\\Desktop\\tasky\\adventofcode\\d10y2016\\d10y2016\\src\\main\\resources\\input.txt");
//        out.println(strings);
        out.println(ValueProcessor.process(strings).outputs());
    }

}