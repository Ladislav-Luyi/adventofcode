package org.example;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.example.AllCombination.choose;


public class Main {
    // part1 141
    public static String input =
            """
AlphaCentauri to Snowdin = 66
AlphaCentauri to Tambi = 28
AlphaCentauri to Faerun = 60
AlphaCentauri to Norrath = 34
AlphaCentauri to Straylight = 34
AlphaCentauri to Tristram = 3
AlphaCentauri to Arbre = 108
Snowdin to Tambi = 22
Snowdin to Faerun = 12
Snowdin to Norrath = 91
Snowdin to Straylight = 121
Snowdin to Tristram = 111
Snowdin to Arbre = 71
Tambi to Faerun = 39
Tambi to Norrath = 113
Tambi to Straylight = 130
Tambi to Tristram = 35
Tambi to Arbre = 40
Faerun to Norrath = 63
Faerun to Straylight = 21
Faerun to Tristram = 57
Faerun to Arbre = 83
Norrath to Straylight = 9
Norrath to Tristram = 50
Norrath to Arbre = 60
Straylight to Tristram = 27
Straylight to Arbre = 81
Tristram to Arbre = 90
            """;


    static HashMap<String,Integer> citiesAndDistance = new HashMap<>();
    public static void main(String[] args) {
        var map = assignIdToCity(); // not 95

//        QuickFind u = new QuickFind(map.size()  );
        Set<String> set = new HashSet<>();
        for (String s : input.split("\n")) {
            String[] split = s.split(" ");
            String origin = split[0];
            String destination = split[2];
            String distance = split[4];
//            System.out.println(origin + " " + destination + " " + distance);
//            u.connect(map.get(origin), map.get(destination));
            citiesAndDistance.put( origin + destination, Integer.valueOf(distance));
            set.add(origin);
            set.add(destination);
        }
        System.out.println(citiesAndDistance);
//        u.print();

        List<String> collect = set.stream().collect(Collectors.toList());
        final int[] min = {Integer.MAX_VALUE};
        final int[] max = {Integer.MIN_VALUE};
        choose(collect, collect.size()).forEach(list -> {
                    int total = 0;
                    for (int i = 1; i < list.size();i++){
                        String s = list.get(i - 1) + list.get(i);
                        boolean b = citiesAndDistance.containsKey(s);
                        if (!b){
                            s = list.get(i) + list.get(i - 1);
                        }
                        total += citiesAndDistance.get(s);
                    }
//                    System.out.println(total);
                    if (total < min[0]){
                        min[0] = total;
                    }
                    if (total > max[0]){
                        max[0] = total;
                    }
                }
                );

        System.out.println(min[0]);
        System.out.println(max[0]);


    }

    private static  HashMap<String, Integer> assignIdToCity() {
        HashMap<String, Integer> r = new HashMap<>();
        AtomicInteger val = new AtomicInteger();
        for (String s : input.split("\n")) {
            r.computeIfAbsent(s.split(" ")[0] , k -> val.getAndIncrement());
            r.computeIfAbsent(s.split(" ")[2] , k -> val.getAndIncrement());
        }
        System.out.println(r);
        return r;
    }

}