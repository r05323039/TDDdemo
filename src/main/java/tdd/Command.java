package tdd;

import lombok.Getter;

@Getter
public class Command {
    private final String name;

    public Command(String commandName) {
        this.name = commandName;
    }
}
