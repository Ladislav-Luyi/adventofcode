package org.example;

import java.util.Comparator;

public class RowComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.r(), o2.r());
    }
}
