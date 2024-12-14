package org.example;

import java.util.Comparator;
import java.util.List;

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

    public Pair sumPairs(Pair a, Pair b){
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

    public boolean pushMagicAButton(){
        Pair xy = a.xy;
        overloadPushes(xy, a);
        return areEqual(value,prize);
    }

    public long multiPushBButton(){
        Pair minusValue = new Pair( -value.x(), -value.y());
        Pair delta = sumPairs(prize, minusValue);
        long l1 =  delta.x() /  b.xy.x();
        long l2 =  delta.y() /  b.xy.y();
        long min = Math.min(l1, l2);
        Pair v = new Pair(b.xy.x() * min, b.xy.y() * min);
        b.override(min * b.tokenCounter, min);
        value = sumPairs(v, value);
        return min;
    }

    public boolean dePushMagicBButton(long times){
        Pair xy = b.xy;
        long x = xy.x();
        long y = xy.y();

        Pair newValue = new Pair(x * -times, y * -times);
        value = sumPairs(value, newValue);
        b.override( b.tokenPrice - b.tokenCounter * times, b.counter - times);
        return areEqual(value,prize);
    }

    private void overloadPushes(Pair xy, Button button) {
        long x = xy.x();
        long y = xy.y();
        long max = Math.max(x, y);
        long times = 0;
        if (x == max) {
            times = prize.x() / x;
        } else {
            times = prize.y() / y;
        }
        Pair newValue = new Pair(x * times, y * times);
        button.override(times * button.tokenCounter, times);
        value = sumPairs(newValue, value);
    }

    public boolean pushMagicBButton(){
        Pair xy = b.xy;
        overloadPushes(xy, b);
        return areEqual(value,prize);
    }

    public boolean pushAutoButton(){
        // naive approach
        Pair xy1 = a.xy;
        Pair xy2 = b.xy;
        // find smallest
        List<Long> x = List.of(xy1.x(), xy1.y(), xy2.x(), xy2.y());
        Long min = x.stream().min(Comparator.naturalOrder()).orElseThrow();
        Pair minPair = null;
        if (xy1.x() == min || xy1.y() == min){
            minPair = xy1;
        }else{
            minPair = xy2;
        }
        if (minPair == xy1){
            return pushMagicAButton();
        }else{
            return pushMagicBButton();
        }
    }

    boolean isWin(){
        return areEqual(value,prize);
    }

}
