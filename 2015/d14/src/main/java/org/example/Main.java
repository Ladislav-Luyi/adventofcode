package org.example;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {

    static String input = """
            Vixen can fly 19 km/s for 7 seconds, but then must rest for 124 seconds.
            Rudolph can fly 3 km/s for 15 seconds, but then must rest for 28 seconds.
            Donner can fly 19 km/s for 9 seconds, but then must rest for 164 seconds.
            Blitzen can fly 19 km/s for 9 seconds, but then must rest for 158 seconds.
            Comet can fly 13 km/s for 7 seconds, but then must rest for 82 seconds.
            Cupid can fly 25 km/s for 6 seconds, but then must rest for 145 seconds.
            Dasher can fly 14 km/s for 3 seconds, but then must rest for 38 seconds.
            Dancer can fly 3 km/s for 16 seconds, but then must rest for 37 seconds.
            Prancer can fly 25 km/s for 6 seconds, but then must rest for 143 seconds.
                        """;

//    static String input = """
//Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.
//Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.
//            """;
    static Pattern pattern = Pattern.compile("(\\w+) \\w+ \\w+ (\\d+) \\w+.\\w+ \\w+ (\\d+) \\w+. \\w+ \\w+ \\w+ \\w+ \\w+ (\\d+) \\w+.", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Reindeer> collect = Arrays.stream(input.split("\n"))
                .map(Main::makeReindeer)
                .toList();
        IntStream.range(0, 2503)
                .forEach(i -> {
                    collect.forEach(Reindeer::move);
                    processPoints(collect);
                });
        // distance
        Optional<Reindeer> maxDistance = collect.stream().max(Comparator.comparing(Reindeer::getDistance));
        System.out.println("distance:  " + maxDistance.orElseThrow().getDistance());
        // points
        Optional<Reindeer> maxPoints = collect.stream().max(Comparator.comparing(Reindeer::getPoints));
        System.out.println("points: " + maxPoints.orElseThrow().getPoints());


    }

    private static void processPoints(List<Reindeer> collect) {
        HashMap<Integer, List<Reindeer>> map = new HashMap<>();
        for (Reindeer reindeer : collect) {
            map.computeIfAbsent(
                    reindeer.getDistance(),
                    k -> new ArrayList<>()).add(reindeer);
        }
        Optional<Integer> highestDistanceTraveled =
                map.keySet().stream().max(Comparator.naturalOrder());
        map.get(highestDistanceTraveled.orElseThrow())
                .forEach(Reindeer::addPoint);
    }

    private static Reindeer makeReindeer(String s) {
        Matcher m = pattern.matcher(s);
        boolean b = m.find();
        return new Reindeer(m.group(1),
                Integer.parseInt(m.group(2)),
                Integer.parseInt(m.group(3)),
                Integer.parseInt(m.group(4)));
    }
}