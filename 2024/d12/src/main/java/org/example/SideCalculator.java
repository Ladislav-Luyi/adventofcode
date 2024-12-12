package org.example;

import java.util.*;

public class SideCalculator {
    private final Garden garden;
    private final HashMap<Character, Integer> sidesMapping = new HashMap<>();


    boolean[][] visited;

    public SideCalculator(Garden garden) {
        this.garden = garden;


        for (Side value : Side.values()) {
            visited = new boolean[garden.getPlots().size()][garden.getPlots().get(0).size()];
            run(value);
        }


    }

    public HashMap<Character, Integer> getSidesMapping() {
        return sidesMapping;
    }

    public Optional<Plot> getNextMove(Plot start,
                                      Side side,
                                      Character plotIdentifier) {
        List<List<Plot>> plots = garden.getPlots();
        int row = start.r();
        int col = start.c();
        Plot plot = null;
        try {
            if (side.equals(Side.HORIZONTAL) ) {
                plot = plots.get(row).get(col + 1);
            } else {
                plot = plots.get(row + 1).get(col);
            }

        } catch (IndexOutOfBoundsException e) {
        }
        if (Objects.isNull(plot)) {
            return Optional.empty();
        }
        if (plot.i() == plotIdentifier) {
            return Optional.of(plot);
        }
        return Optional.empty();
    }

    public void run(Side side) {
        for (List<Plot> plots : garden.getPlots()) {
            for (Plot next : plots) {
                if (isVisited(next)) {
                    continue;
                }
                Character plotIdentifier = next.i();
                Set<Plot> collected = new HashSet<>();
                Set<Plot> visited = new HashSet<>();
                visited.add(next);
                processTree(next, plotIdentifier, collected, side, visited);
                if (collected.isEmpty()) {
                    continue;
                }
            }
        }
    }

    private void processTree(Plot plot,
                             Character plotIdentifier,
                             Set<Plot> collected,
                             Side side,
                             Set<Plot> visited
    ) {
        // TODO mark as visited somehow, maybe not needed!!!
        if (isVisited(plot)) {
            return;
        }
        System.out.println("visiting " + plot);
        addToVisited(plot);
        Optional<Plot> next = getNextMove(plot, side, plotIdentifier);
        if (next.isEmpty()) {
            System.out.println("no more to visit");
            return;
        }


        // TODO mark as visited somehow
//            visited[next.r()][next.c()] = true;
        processTree(next.get(), plotIdentifier, collected, side, visited);

    }


    private void addToVisited(Plot plot) {
        visited[plot.r()][plot.c()] = true;
    }

    private boolean isVisited(Plot plot) {
        return visited[plot.r()][plot.c()];
    }


    enum Direction {
        TOP, RIGHT, BOT, LEFT
    }

    enum Side {
        HORIZONTAL, VERTICAL
    }

    public List<Plot> getNextMoves(Plot start, Character plotIdentifier) {
        List<Plot> list = new ArrayList<>();
        List<List<Plot>> plots = garden.getPlots();
        int row = start.r();
        int col = start.c();
        // find which sides is possible to count by checking what is next to it, because it was already counted
        // get possible directions for checks
        // process directions and count sides and set new counts to FALSE


        for (PlotCrawler.Direction d : PlotCrawler.Direction.values()) {
            try {
                if (d.equals(PlotCrawler.Direction.TOP)){
                    list.add(plots.get(row-1).get(col));
                }
                if (d.equals(PlotCrawler.Direction.RIGHT)){
                    list.add(plots.get(row).get(col+1));
                }
                if (d.equals(PlotCrawler.Direction.BOT)){
                    list.add(plots.get(row+1).get(col));
                }
                if (d.equals(PlotCrawler.Direction.LEFT)){
                    list.add(plots.get(row).get(col -1));
                }

            } catch (IndexOutOfBoundsException e) {
            }
        }

        return
                list.stream().filter(e -> e.i() == plotIdentifier )
                        .toList();
    }

}
