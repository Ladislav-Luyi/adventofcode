package org.example;

import java.util.*;

public class PlotCrawler {

    private Garden garden;
    boolean[][] visited;

    public PlotCrawler(Garden garden) {
        this.garden = garden;
        visited = new boolean[garden.getPlots().size()][garden.getPlots().get(0).size()];
    }

    void showVisted(){
        for (boolean[] booleans : visited) {
            for (boolean b : booleans) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }


    public List<Plot> getNextMoves(Plot start, Character plotIdentifier) {
        List<Plot> list = new ArrayList<>();
        List<List<Plot>> plots = garden.getPlots();
        int row = start.r();
        int col = start.c();
        for (Direction d : Direction.values()) {
            try {
                if (d.equals(Direction.TOP)){
                    list.add(plots.get(row-1).get(col));
                }
                if (d.equals(Direction.RIGHT)){
                    list.add(plots.get(row).get(col+1));
                }
                if (d.equals(Direction.BOT)){
                    list.add(plots.get(row+1).get(col));
                }
                if (d.equals(Direction.LEFT)){
                    list.add(plots.get(row).get(col -1));
                }

            } catch (IndexOutOfBoundsException e) {
            }
        }

        return
        list.stream().filter(e -> e.i() == plotIdentifier )
                .toList();
    }

    enum Direction{
        TOP, RIGHT, BOT, LEFT
    }

    public void run(){
        for (List<Plot> plots : garden.getPlots()) {
            for(Plot next : plots) {
                if (visited[next.r()][next.c()]){
                    continue;
                }
                Character plotIdentifier = next.i();
                Set<Plot> collected = new HashSet<>();
                processTree(next, plotIdentifier, collected);
                if (collected.isEmpty()){
                    continue;
                }
                int perimiter =  calculatePerimiter( collected );
                garden.regions.add(new Region(next.i(), collected, perimiter));
            }
        }
    }

    private int calculatePerimiter(Set<Plot> collected) {
        int sum = 0;
        for (Plot plot : collected) {
            List<Plot> nextMoves = getNextMoves(plot, plot.i());
            sum += 4 - nextMoves.size();

        }
        return sum;
    }

    private void processTree(Plot start, Character plotIdentifier, Set<Plot> collected) {
        visited[start.r()][start.c()] = true;
        collected.add(start);
        List<Plot> nextMoves = getNextMoves(start, plotIdentifier);
        Iterator<Plot> iterator = nextMoves.iterator();
        while(iterator.hasNext()){
            Plot next = iterator.next();
            if (visited[next.r()][next.c()]){
                continue;
            }
            visited[next.r()][next.c()] = true;
            processTree(next, plotIdentifier, collected);
        }

    }


}
