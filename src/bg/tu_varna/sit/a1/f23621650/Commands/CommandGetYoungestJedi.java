package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;
import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * Command to get and print the youngest Jedi of a specific rank on a given planet.
 * Usage:
 * - get_youngest_jedi planet_name jedi_rank
 */
public class CommandGetYoungestJedi implements Command {
    private final StarWarsUniverse universe;

    public CommandGetYoungestJedi() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the get_youngest_jedi command.
     *
     * @param input command arguments: [command, planet_name, jedi_rank]
     */
    @Override
    public void execute(String[] input) {
        try {
            if(input.length != 3) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
            universe.getYoungestJedi(input[1], JediRank.valueOf(input[2].toUpperCase()));
        } catch (PlanetManagementException | JediManagementException e) {
            System.out.println(e.getMessage());
        }
    }
}
