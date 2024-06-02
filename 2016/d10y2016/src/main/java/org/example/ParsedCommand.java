package org.example;

public record ParsedCommand(SubjectOfCommand typeOfGiver,
                            Integer giver,
                            SubjectOfCommand typeOfReceiver,
                            Integer receiver,
                            TypeOfItemInCommand typeOfItemInCommand) {
}

