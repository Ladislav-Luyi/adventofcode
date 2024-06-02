package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ValueProcessorTest {

    @Test
    void process() {
        List<String> strings = new ArrayList<>();
        strings.add("value 5 goes to bot 2");
        strings.add("bot 2 gives low to bot 1 and high to bot 0");
        strings.add("value 3 goes to bot 1");
        strings.add("bot 1 gives low to output 1 and high to bot 0");
        strings.add("bot 0 gives low to output 2 and high to output 0");
        strings.add("value 2 goes to bot 2");
        ValueProcessor.Outputs outputs = ValueProcessor.process(strings);
        System.out.println(outputs);
        Assertions.assertEquals(5, outputs.outputs().stream().filter(nameAndValues -> nameAndValues.bot().equals(0)).findFirst().get().values().get(0));
        Assertions.assertEquals(2, outputs.outputs().stream().filter(nameAndValues -> nameAndValues.bot().equals(1)).findFirst().get().values().get(0));
        Assertions.assertEquals(3, outputs.outputs().stream().filter(nameAndValues -> nameAndValues.bot().equals(2)).findFirst().get().values().get(0));
    }

    @Test
    void parseCommand() {

//        SubjectOfCommand.valueOf("bot");

       String s = "bot 0 gives low to output 2 and high to output 0";
       ParsedCommand[] parsedCommands = ValueProcessor.getParsedCommands(s);
       Stream.of(parsedCommands).forEach(System.out::println);


    }
}