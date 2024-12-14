package org.example;

public class Robot {
    // right/left  top/down
    public Pair location;

    // right/left  top/down
    public Pair speedAndDirection;

    // wide/tall
    public Pair area;

    public Robot(Pair location, Pair velocity, Pair area) {
        this.location = location;
        this.speedAndDirection = velocity;
        this.area = area;
    }

    public void move(){
        // vertical
        int rowLocation = location.x();
        int rowDirAndSpeed = speedAndDirection.x();
        int tall = area.x();
        int newXLocation = 0;
        int delta = rowLocation + rowDirAndSpeed;
        if (delta >= 0 &&  delta < tall ){
            newXLocation = delta;
        }else
        if (delta < 0){
            newXLocation =  tall + delta ;
        }
        else
        {
            newXLocation =  delta - tall;
//            newXLocation =  Math.abs(tall - delta);

        }
        // horizontal
        int colLocation = location.y();
        int colDirAndSpeed = speedAndDirection.y();
        int wide = area.y();
        int newYLocation = 0;
        int delta1 = colLocation + colDirAndSpeed;
        if (delta1 >= 0 &&  delta1 < wide){
            newYLocation = delta1;
        }
        else
        if (delta1 < 0){
            newYLocation =  wide + delta1;
        }
        else
        {
//            newYLocation =  Math.abs(  wide - delta );
            newYLocation =   delta1 - wide;
        }


        location = new Pair(newXLocation, newYLocation);
    }

    @Override
    public String toString() {
        return "Robot{" +
               "location=" + location +
               ", speedAndDirection=" + speedAndDirection +
               ", area=" + area +
               '}';
    }

    boolean amIinMiddle(){
        int r = area.x() / 2;
        int c = area.y() / 2;
        return location.x() == r && location.y() == c;
    }

    int getQuadrant(){
        int r = area.x() / 2;
        int c = area.y() / 2;
        // 1 2 | 3 4
        if (amIinMiddle()){
            return -1;
        }
        boolean isUpperQuadrant = location.x() < r;
        boolean isLeftQuadrant = location.y() < c;

        if (isUpperQuadrant && isLeftQuadrant){
            return 1;
        }else if (isUpperQuadrant){
            return 2;
        }else if (isLeftQuadrant){
            return 3;
        }else{
            return 4;
        }
    }

}
