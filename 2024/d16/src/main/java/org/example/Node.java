package org.example;

import java.util.Objects;

public final class Node {
    private final int r;
    private final int c;
    private char i;
    private final Direction d;

    public Node(int r, int c, char i, Direction d) {
        this.r = r;
        this.c = c;
        this.i = i;
        this.d = d;
    }

    public int r() {
        return r;
    }

    public int c() {
        return c;
    }

    public char i() {
        return i;
    }

    public Direction d() {
        return d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Node) obj;
        return this.r == that.r &&
               this.c == that.c &&
               this.i == that.i &&
               Objects.equals(this.d, that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c, i, d);
    }

    @Override
    public String toString() {
        return "Node[" +
               "r=" + r + ", " +
               "c=" + c + ", " +
               "i=" + i + ", " +
               "d=" + d + ']';
    }

    public void setI(char i) {
        this.i = i;
    }
}
