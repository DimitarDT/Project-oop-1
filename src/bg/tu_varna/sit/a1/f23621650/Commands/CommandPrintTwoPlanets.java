package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * Command to print all Jedi from two planets sorted alphabetically.
 * Expects input format: planet1 + planet2
 */
public class CommandPrintTwoPlanets implements Command {
    private final StarWarsUniverse universe;

    public CommandPrintTwoPlanets() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the print command for two planets.
     * @param input expects exactly 3 elements: [planet1, "+", planet2]
     *              where input[1] should be "+"
     */
    @Override
    public void execute(String[] input) {
        universe.printTwoPlanetsJedis(input[0], input[2]);
    }
}
