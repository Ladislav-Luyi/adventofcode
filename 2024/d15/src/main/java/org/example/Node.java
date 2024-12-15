package org.example;

public class Node {
    BoxType boxType;
    int row;
    int colLeft;
    int colRight;

    public Node(BoxType boxType, int row, int colLeft, int colRight) {
        this.boxType = boxType;
        this.row = row;
        this.colLeft = colLeft;
        this.colRight = colRight;
    }

    public BoxType getBoxType() {
        return boxType;
    }

    public int getRow() {
        return row;
    }

    public int getColLeft() {
        return colLeft;
    }

    public int getColRight() {
        return colRight;
    }

    @Override
    public String toString() {
        if (boxType.equals(BoxType.WALL)){
            return "#";
        }else
        if (boxType.equals(BoxType.EMPTY)){
            return ".";
        }else
        if (boxType.equals(BoxType.ROBOT)){
            return "@";
        }
        else {
            return "[]";
        }
    }
}
