package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

public class CommandPrintTwoPlanets implements Command {
    private final StarWarsUniverse universe;

    public CommandPrintTwoPlanets() {
        this.universe = StarWarsUniverse.getInstance();
    }

    @Override
    public void execute(String[] input) {
        universe.printTwoPlanetsJedis(input[0], input[2]);
    }
}
