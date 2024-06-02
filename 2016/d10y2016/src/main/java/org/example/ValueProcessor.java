package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class ValueProcessor {

    static List<NameAndValues> bots = new ArrayList<>();
    static List<NameAndValues> outputs = new ArrayList<>();

    static Outputs process(List<String> strings) {
        Queue<String> valuesToAdd = new PriorityQueue<>();
        List<CommandAndStatus> commands = new ArrayList<>();
        for (String s : strings) {
            if (s.matches("^bot.*")) {
                commands.add(new CommandAndStatus(getParsedCommands(s), false));
            } else {
                valuesToAdd.add(s);
            }
        }
        while (commands.stream().anyMatch(commandWithStatus -> commandWithStatus.status.equals(false))) {
            String valuesToBot = valuesToAdd.poll();
            if (valuesToBot == null) throw new RuntimeException("not enough values to bots, something went wrong");
            addValueToBot(getBotAndValue(valuesToBot));
            while (bots.stream().anyMatch(integers -> integers.values.size() >= 2)) {
                // find first bot which has two values
                Optional<NameAndValues> first = bots.stream().filter(integers -> integers.values.size() >= 2).findFirst();
                // find index of matching command to bot from above
                OptionalInt foundedIndexOpt = IntStream.range(0, commands.size()).filter(index ->
                        commands.get(index).status.equals(false) &&
                        commands.get(index).commands[0].giver().equals(first.get().bot)).findFirst();
                int indexOfRelevantCommand = foundedIndexOpt.orElseThrow(RuntimeException::new);
                CommandAndStatus commandAndStatus = commands.get(indexOfRelevantCommand);
                for (ParsedCommand pc : commandAndStatus.commands) {
                    performCommand(pc);
                }
                commands.set(indexOfRelevantCommand, new CommandAndStatus(null, true));
            }
        }
        return new Outputs(bots, outputs);
    }

    private static void addValueToBot(BotAndValue botAndValue) {
        int bot = botAndValue.bot;
        int value = botAndValue.value;
        NameAndValues nv = bots.stream()
                .filter(nameAndValues -> nameAndValues.bot.equals(bot))
                .findFirst()
                .orElse(new NameAndValues(bot, new ArrayList<>()));
        bots.remove(nv);
        nv.values().add(value);
        bots.add(nv);
    }

    public static ParsedCommand[] getParsedCommands(String command) {
        String regex = "(\\w+) (\\d+) gives (\\w+) to (\\w+) (\\d+) and (\\w+) to (\\w+) (\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        if (!matcher.find()) throw new RuntimeException();
        SubjectOfCommand giverType = SubjectOfCommand.valueOf(matcher.group(1).toUpperCase());
        Integer giverBot = Integer.valueOf(matcher.group(2));
        TypeOfItemInCommand typeOfValue1 = TypeOfItemInCommand.valueOf(matcher.group(3).toUpperCase());
        SubjectOfCommand typeOfReceiver1 = SubjectOfCommand.valueOf(matcher.group(4).toUpperCase());
        Integer receiverBot1 = Integer.valueOf(matcher.group(5));
        TypeOfItemInCommand typeOfValue2 = TypeOfItemInCommand.valueOf(matcher.group(6).toUpperCase());
        SubjectOfCommand typeOfReceiver2 = SubjectOfCommand.valueOf(matcher.group(7).toUpperCase());
        Integer receiverBot2 = Integer.valueOf(matcher.group(8));
        ParsedCommand p1 = new ParsedCommand(giverType, giverBot, typeOfReceiver1, receiverBot1, typeOfValue1);
        ParsedCommand p2 = new ParsedCommand(giverType, giverBot, typeOfReceiver2, receiverBot2, typeOfValue2);
        return new ParsedCommand[]{p1, p2};
    }

    private static BotAndValue getBotAndValue(String valuesToBot) {
        String regex = "value (\\d+) goes to bot (\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valuesToBot);
        if (!matcher.find()) throw new RuntimeException();
        int value = Integer.parseInt(matcher.group(1));
        int bot = Integer.parseInt(matcher.group(2));
        return new BotAndValue(value, bot);
    }

    static void performCommand(ParsedCommand parsedCommand) {
        NameAndValues nvGiver = bots.stream().filter(nameAndValues -> nameAndValues.bot.equals(parsedCommand.giver()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("giver bot is not exist, something went wrong"));

//        System.out.println(nvGiver); // part 1 answer
        Integer value;
        if (parsedCommand.typeOfItemInCommand().equals(TypeOfItemInCommand.HIGH)) {
            value = nvGiver.values().stream()
                    .max(Comparator.naturalOrder())
                    .orElseThrow(RuntimeException::new);
        } else {
            value = nvGiver.values().stream()
                    .min(Comparator.naturalOrder())
                    .orElseThrow(RuntimeException::new);
        }
        nvGiver.values().remove(value);

        if (parsedCommand.typeOfReceiver().equals(SubjectOfCommand.BOT)) {
            NameAndValues nvReceiver = bots.stream().filter(nameAndValues -> nameAndValues.bot.equals(parsedCommand.receiver()))
                    .findFirst()
                    .orElse(new NameAndValues(parsedCommand.receiver(), new ArrayList<>()));
            bots.remove(nvReceiver);
            nvReceiver.values().add(value);
            bots.add(nvReceiver);
        } else {
            NameAndValues nvReceiver = outputs.stream().filter(nameAndValues -> nameAndValues.bot.equals(parsedCommand.receiver()))
                    .findFirst()
                    .orElse(new NameAndValues(parsedCommand.receiver(), new ArrayList<>()));
            outputs.remove(nvReceiver);
            nvReceiver.values().add(value);
            outputs.add(nvReceiver);
//            if (nvReceiver.bot.equals(0) || nvReceiver.bot.equals(1) || nvReceiver.bot.equals(2)){
//                System.out.println(nvReceiver);
//            } // part two answer
        }
    }

    public record NameAndValues(Integer bot, List<Integer> values) {
    }

    public record Outputs(List<NameAndValues> bots, List<NameAndValues> outputs) {
    }

    public record CommandAndStatus(ParsedCommand[] commands, Boolean status) {
    }
    private record BotAndValue(int value, int bot) {
    }
}


