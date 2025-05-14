package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

public class CommandClose implements Command{
    private final StarWarsUniverse universe;

    public CommandClose() {
        this.universe = StarWarsUniverse.getInstance();
    }

    @Override
    public void execute(String[] input) {
        universe.close();
    }
}
