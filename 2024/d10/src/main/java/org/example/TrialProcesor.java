package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TrialProcesor {

    private Trial trial;
    private List<Triple> start = new ArrayList<>();
    boolean[][] visited;

    int score = 0;
    public TrialProcesor(Trial trial) {
        this.trial = trial;
        for (List<Triple> triples : trial.getTrial()) {
            for (Triple triple : triples) {
                if (triple.i() == 0){
                    start.add(triple);
                }
            }
        }
        visited = new boolean[trial.getTrial().size()][trial.getTrial().get(0).size()];
    }

    void showVisted(){
        for (boolean[] booleans : visited) {
            for (boolean b : booleans) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }


    public List<Triple> getNextMoves(Triple start) {
        List<Triple> list = new ArrayList<>();
        List<List<Triple>> tripleLIst = trial.getTrial();
        int row = start.r();
        int col = start.c();
        int value = start.i();
        for (Direction d : Direction.values()) {
            try {
                if (d.equals(Direction.TOP)){
                    list.add(tripleLIst.get(row-1).get(col));
                }
                if (d.equals(Direction.RIGHT)){
                    list.add(tripleLIst.get(row).get(col+1));
                }
                if (d.equals(Direction.BOT)){
                    list.add(tripleLIst.get(row+1).get(col));
                }
                if (d.equals(Direction.LEFT)){
                    list.add(tripleLIst.get(row).get(col -1));
                }

            } catch (IndexOutOfBoundsException e) {
            }
        }

        return
        list.stream().filter(triple -> triple.i() == value + 1 )
                .toList();
    }

    enum Direction{
        TOP, RIGHT, BOT, LEFT
    }

    public int evaluateScore(){
        HashSet<Triple> set = new HashSet<>();
        for(Triple next : start) {
            processTree(next, set);
            visited = new boolean[trial.getTrial().size()][trial.getTrial().get(0).size()];
        }
        System.out.println(set);
        return score;
    }

    private void processTree(Triple start, HashSet<Triple> set) {
        List<Triple> nextMoves = getNextMoves(start);
        Iterator<Triple> iterator = nextMoves.iterator();
        while(iterator.hasNext()){
            Triple next = iterator.next();
            if (visited[next.r()][next.c()]){
                continue;
            }
            if (next.i() == 9){
                score++;
                set.add(next);
            }
            visited[next.r()][next.c()] = true;
            System.out.println("procesing " + next);
            processTree(next, set);

        }

    }


}
