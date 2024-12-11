package org.example;


import org.w3c.dom.css.Counter;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String input = """
            9861
            """;

    private static ArrayList<Long> compute(ArrayList<Long> list, HashSet<Long> counts35) {
        ArrayList<Long> newList = new ArrayList<>();
        for (Long i : list) {
            counts35.add(i);
            if (i == 0){
                newList.add(1L);
            }
            else
            if (i.toString().length() % 2 == 0){
                String tmp = i.toString();
                int n = tmp.length();
                String one = tmp.substring(0,n / 2);
                String two = tmp.substring(n / 2);
                one = replaceIfExtraLeadingZero(one);
                two = replaceIfExtraLeadingZero(two);
                newList.add(Long.valueOf(one));
                newList.add(Long.valueOf(two));
            }
            else{
                newList.add( i * 2024 );
            }
        }
        return newList;
    }
    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(0);

        ArrayList<Long> list = new ArrayList<>();
        // 164601 too low
        HashSet<Long> counts35 = new HashSet<>();
        for (String s : input.split("\\s+")) {
            list.add(Long.valueOf(s));
        }
//        System.out.println("before " + list);
        int blinks = 40;
        for (int blink = 0; blink < blinks; blink++) {
            list = compute(list, counts35);
//            System.out.println("after " + list);
        }
        System.out.println(list.size());
        System.out.println(counts35.size());

        blinks = 35;

        HashMap<Long,Integer> counts = new HashMap<>();
        for (Long l : counts35.stream().toList()) {
            ArrayList<Long> objects = new ArrayList<>();
            objects.add(l);
            for (int blink = 0; blink < blinks; blink++) {
                objects = compute(objects, counts35);
            }
            counts.putIfAbsent(l, objects.size());
        }
        System.out.println(counts);


        for (Long l : list) {
             if (counts.containsKey(l)){
                sum = sum.add(new BigDecimal(counts.get(l)));
                continue;
            }
            ArrayList<Long> objects = new ArrayList<>();
            objects.add(l);
            for (int blink = 0; blink < blinks; blink++) {
                objects = compute(objects, counts35);
            }
            sum = sum.add(new BigDecimal(objects.size()));
        }
        System.out.println(sum);


//        System.out.println("final " + list.size());
        /////////////////////////


//        long[] array = new long[1_000_000];
//        Arrays.fill(array,-1L);
//
//        long[] newArray = new long[1_000_000];
//        Arrays.fill(newArray,-1L);
//
//        int Outerindex = 0;
//        for (Long s1 : list) {
////            System.out.println("processing " + Outerindex++ + " from " + list.size());
//            Arrays.fill(array,-1L);
//            Arrays.fill(newArray,-1L);
//            array[0] = s1;
//
//            if (counts.containsKey(s1)){
//                sum += counts.get(s1);
//                continue;
//            }
//
//            for (int blink = 0; blink < blinks; blink++) {
//                int index = 0;
//                for (long i : array) {
//                    if (i == -1) {
//                        break;
//                    }
//                    String s = String.valueOf(i);
//                    if (i == 0) {
//                        newArray[index++] = 1L;
//                    } else if (s.length() % 2 == 0) {
//                        int n = s.length();
//                        String one = s.substring(0, n / 2);
//                        String two = s.substring(n / 2);
//                        one = replaceIfExtraLeadingZero(one);
//                        two = replaceIfExtraLeadingZero(two);
//                        newArray[index++] = Long.parseLong(one);
//                        newArray[index++] = Long.parseLong(two);
//                    } else {
//                        newArray[index++] = i * 2024;
//                    }
//                }
//                array = Arrays.copyOf(newArray, newArray.length);
//                ;
//            }
//
//            for (long l : array) {
//                if (l == -1) {
//                    break;
//                }
//                sum++;
//            }
//        }
//        System.out.println(sum);


    }



    private static String replaceIfExtraLeadingZero(String s) {
        if (s.length() == 1){
            return s;
        }
        if (s.matches("^0+$")){
            return "0";
        }
        return s;
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