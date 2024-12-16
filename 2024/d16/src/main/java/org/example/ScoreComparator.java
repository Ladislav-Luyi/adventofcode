package org.example;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Move> {

    @Override
    public int compare(Move o1, Move o2) {
        return Integer.compare(o1.points(), o2.points());
    }
}
