package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

public class CommandReadFromFile implements Command {
    private final StarWarsUniverse universe;

    public CommandReadFromFile() {
        this.universe = StarWarsUniverse.getInstance();
    }

    @Override
    public void execute(String[] input) {
        if(input.length != 2) {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }
        universe.readFromFile(input[1]);
    }
}
