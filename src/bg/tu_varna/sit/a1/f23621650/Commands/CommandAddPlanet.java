package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;
import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * Command to add a new planet to the Star Wars universe.
 * Usage: add_planet planet_name
 */
public class CommandAddPlanet implements Command {
    private final StarWarsUniverse universe;

    public CommandAddPlanet() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the add planet command.
     *
     * @param input command input tokens, where input[1] should be the planet name.
     */
    @Override
    public void execute(String[] input) {
        try {
            if(input.length != 2) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
            universe.addPlanetToUniverse(input[1]);
        } catch (PlanetManagementException e) {
            System.out.println(e.getMessage());
        }
    }
}
