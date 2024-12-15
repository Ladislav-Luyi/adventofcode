package org.example;

import java.util.Comparator;

public class ColumnComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.c(), o2.c());
    }

}
