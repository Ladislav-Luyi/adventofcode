package org.example;

public class Button {

    String id;
    Pair xy;
    int counter = 0;

    int tokenCounter, tokenPrice;

    public Button(String id, Pair xy, int tokenCounter) {
        this.id = id;
        this.xy = xy;
        this.tokenCounter = tokenCounter;
    }

    Pair push(){
        tokenPrice += tokenCounter;
        counter++;
        return xy;
    }

    Pair dePush(){
        tokenPrice -= tokenCounter ;
        counter--;
        return new Pair(-xy.x(), -xy.y());
    }

    @Override
    public String toString() {
        return "Button{" +
               "id='" + id + '\'' +
               ", xy=" + xy +
               '}';
    }
}
