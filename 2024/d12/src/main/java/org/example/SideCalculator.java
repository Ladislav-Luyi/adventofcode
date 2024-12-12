package org.example;

import java.util.*;

public class SideCalculator {
    private final Garden garden;
    HashMap<Character, Integer> sides = new HashMap<>();
    List<Plot> matches = new ArrayList<>();

    public SideCalculator(Garden garden) {
        this.garden = garden;
//        HashSet<Character> uniqIds = new HashSet<>();
        List<List<Plot>> plots = garden.getPlots();
//        for (List<Plot> inner : plots) {
//            for (Plot plot : inner) {
//                uniqIds.add(plot.i());
//            }
//
//        }

        List<Direction> verticalCheck = List.of(Direction.LEFT, Direction.RIGHT);
        List<Direction> horizonalCheck = List.of(Direction.TOP, Direction.BOT);


        for (Region region : garden.regions) {
            for (Direction direction : verticalCheck) {
                for (int i = 0; i < plots.get(0).size(); i++) {
                    boolean isMatchCounted = true;
                    for (int j = 0; j < plots.size(); j++) {
                        Optional<Plot> tmp = getPlot(j, i);
                        Plot plot = tmp.orElse(new Plot(j, i, '-'));
                        if (!region.plots.contains(plot)) {
                            continue;
                        }
                        boolean isMatch = isNextSame(plot, region.getRegionId() , direction);
                        if (!isMatch && isMatchCounted) {
                            region.sides++;
                            isMatchCounted = false;
                        }
                        if (isMatch || !isNextSame(plot, region.getRegionId() , Direction.BOT)){
                            isMatchCounted = true;
                        }
                    }
                    System.out.println();
                }
            }
        }


        for (Region region : garden.regions) {

            for (Direction direction : horizonalCheck) {

                // from left to right
                for (int i = 0; i < plots.size(); i++) {
                    boolean isMatchCounted = true;
                    for (int j = 0; j < plots.get(0).size(); j++) {
                        Optional<Plot> tmp = getPlot(i, j);
                        Plot plot = tmp.orElse(new Plot(i, j, '-'));
                        if (!region.plots.contains(plot)) {
                            continue;
                        }
                        boolean isMatch = isNextSame(plot, region.getRegionId() , direction);
                        if (!isMatch && isMatchCounted) {
                            region.sides++;
                            isMatchCounted = false;
                        }
                        if (isMatch || !isNextSame(plot, region.getRegionId() , Direction.RIGHT)){
                            isMatchCounted = true;
                        }
                    }
                }
            }


        }


    }

    public HashMap<Character, Integer> getSides() {
        return sides;
    }

    private Optional<Plot> getPlot(int i, int j) {
        try {
            return Optional.of(garden.getPlots().get(i).get(j));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }


    public boolean isNextSame(Plot start, Character id, Direction d) {
        List<List<Plot>> plots = garden.getPlots();
        int row = start.r();
        int col = start.c();

        try {
            if (d.equals(Direction.TOP)) {
                return plots.get(row - 1).get(col).i() == id;
            }
            if (d.equals(Direction.RIGHT)) {
                boolean b = plots.get(row).get(col + 1).i() == id;
                if (b) {
//                    System.out.println(d + " " + plots.get(row).get(col + 1));
//                    matches.add(plots.get(row).get(col + 1));
                }
                return b;
            }
            if (d.equals(Direction.BOT)) {
                return plots.get(row + 1).get(col).i() == id;
            } else {
                boolean b = plots.get(row).get(col - 1).i() == id;
                if (b) {
                    matches.add(plots.get(row).get(col - 1));
//                    System.out.println(d + " " + plots.get(row).get(col - 1));
                }
                return b;
            }

        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    enum Direction {
        TOP, RIGHT, BOT, LEFT
    }


}
