package org.example;

import java.util.*;

public class SideCalculator {
    private final Garden garden;
    HashMap<Character, Integer> sides = new HashMap<>();
    List<Plot> matches = new ArrayList<>();

    public SideCalculator(Garden garden) {
        this.garden = garden;
        HashSet<Character> uniqIds = new HashSet<>();
        List<List<Plot>> plots = garden.getPlots();
        for (List<Plot> inner : plots) {
            for (Plot plot : inner) {
                uniqIds.add(plot.i());
            }

        }

        List<Direction> verticalCheck = List.of(Direction.LEFT, Direction.RIGHT);
        List<Direction> horizonalCheck = List.of(Direction.TOP, Direction.BOT);


        for (Character id : uniqIds) {
//         from top down

            for (Direction direction : verticalCheck) {
                boolean isMatchCounted = true;
                for (int i = -1; i < plots.get(0).size() + 1; i++) {

                    for (int j = -1; j < plots.size() + 1; j++) {

                        Optional<Plot> tmp = getPlot(j, i);
                        Plot plot = tmp.orElse(new Plot(j, i, '-'));
                        System.out.print(plot + " ");

                        if (plot.i() == id) {
                            continue;
                        }

                        if (isNextSame(plot, id, Direction.TOP)) {
                            isMatchCounted = true;
                        }

                        if (direction.equals(Direction.LEFT)) {
                            if (!isNextSame(plot, id, Direction.LEFT)) {
                                isMatchCounted = true;
                            }
                        }

                        if (direction.equals(Direction.RIGHT)) {
                            if (!isNextSame(plot, id, Direction.RIGHT)) {
                                isMatchCounted = true;
                            }
                        }



                        boolean isMatch = isNextSame(plot, id, direction);
                        if (isMatch && isMatchCounted) {
                            sides.merge(id, 1, Integer::sum);
                            isMatchCounted = false;
                        }
                    }
                    System.out.println();
                }
            }
        }


        for (Character id : uniqIds) {

            for (Direction direction : horizonalCheck) {

                // from left to right
                for (int i = -1; i < plots.size() + 1; i++) {
                    boolean isMatchCounted = true;
                    for (int j = -1; j < plots.get(0).size() + 1; j++) {
                        Optional<Plot> tmp = getPlot(i, j);
                        Plot plot = tmp.orElse(new Plot(i, j, '-'));


                        if (plot.i() == id) {
                            continue;
                        }

                        if (isNextSame(plot, id, Direction.RIGHT)) {
                            isMatchCounted = true;
                        }

                        if (direction.equals(Direction.TOP)) {
                            if (!isNextSame(plot, id, Direction.TOP)) {
                                isMatchCounted = true;
                            }
                        }

                        if (direction.equals(Direction.BOT)) {
                            if (!isNextSame(plot, id, Direction.BOT)) {
                                isMatchCounted = true;
                            }
                        }


                        boolean isMatch = isNextSame(plot, id, direction);
                        if (isMatch && isMatchCounted) {
                            sides.merge(id, 1, Integer::sum);
                            isMatchCounted = false;
                        }
//                        System.out.print(plot + " ");
                    }
//                    System.out.println();
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
