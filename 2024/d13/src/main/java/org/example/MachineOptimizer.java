package org.example;

import java.util.Comparator;
import java.util.HashSet;

public class MachineOptimizer {
    private final Machine machine;

    private final Result result;
    public MachineOptimizer(Machine machine) {
        this.machine = machine;

        HashSet<Long> tokens = new HashSet<>();


        if (machine.pushMagicAButton()){
            tokens.add(machine.getTokenPrice());
        }
        System.out.println(machine);
        // increase
        while(true){
            if (machine.value.x() > machine.prize.x() || machine.value.y() > machine.prize.y()){
                break;
            }
            System.out.println("true");
            boolean b = machine.pushA();
            if (b){
                System.out.println(machine.a.counter + " " + machine.b.counter);
                System.out.println(machine.a.tokenPrice + " " + machine.b.tokenPrice);
                tokens.add(machine.getTokenPrice());
            }
        }


        long pushCounter = 0;
        // decrease
        while(true){
            boolean b1 = machine.dePushA();
            while (true) {
                if (machine.value.x() > machine.prize.x() || machine.value.y() > machine.prize.y()){
                    break;
                }
                boolean b2 = machine.pushB();
                pushCounter++;
                if (b2) {
                    System.out.println(machine.a.counter + " " + machine.b.counter);
                    System.out.println(machine.a.tokenPrice + " " + machine.b.tokenPrice);
                    tokens.add(machine.getTokenPrice());
                }
            }
            //reset
//            for (long i = 0; i < pushCounter; i++){
//                boolean b = machine.dePushB();
//                if (b) {
//                    System.out.println(machine.a.counter + " " + machine.b.counter);
//                    System.out.println(machine.a.tokenPrice + " " + machine.b.tokenPrice);
//                    tokens.add(machine.getTokenPrice());
//                }
//            }
            if (machine.dePushMagicBButton(pushCounter)) {
                System.out.println(machine.a.counter + " " + machine.b.counter);
                System.out.println(machine.a.tokenPrice + " " + machine.b.tokenPrice);
                tokens.add(machine.getTokenPrice());
            }
            pushCounter=0;
            if (machine.a.tokenPrice == 0){
                break;
            }
        }

        result =  new Result(
                !tokens.isEmpty(),
                tokens.stream().min(Comparator.naturalOrder()).orElse(-1L));
    }

    Result getResult(){
        return result;
    }

}
