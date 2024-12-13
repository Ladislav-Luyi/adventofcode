package org.example;

import java.util.HashMap;

public class Machine {
    Button a, b;
    Pair prize;
    Pair value;

    long tokenPrice = 0;

    public Machine(Pair a, Pair b, Pair prize) {
        this.a = new Button("a", a, 3);
        this.b = new Button("b", b, 1);
        this.prize = prize;
        this.value = new Pair(0,0);
    }

    boolean pushA(){
        value = sumPairs(a.push(), value);
        return areEqual(value,prize);
    }

    boolean dePushA(){
        value = sumPairs(a.dePush(), value);
        return areEqual(value,prize);
    }

    boolean pushB(){
        value = sumPairs(b.push(), value);
        return areEqual(value,prize);
    }

    boolean dePushB(){
        value = sumPairs(b.dePush(), value);
        return areEqual(value,prize);
    }

    private boolean areEqual(Pair value, Pair prize) {
        return value.x() == prize.x() && value.y() == prize.y();
    }

    private Pair sumPairs(Pair a, Pair b){
        return new Pair(a.x() + b.x(), a.y() + b.y());
    }

    @Override
    public String toString() {
        return "Machine{" +
               "a=" + a +
               ", b=" + b +
               ", prize=" + prize +
               ", value=" + value +
               '}';
    }

    long getTokenPrice(){
        return a.tokenPrice + b.tokenPrice;
    }
}
