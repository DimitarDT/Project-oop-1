package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;
import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * Command to remove a Jedi from a specific planet.
 * Usage: remove_jedi jedi_name planet_name
 */
public class CommandRemoveJedi implements Command {
    private final StarWarsUniverse universe;

    public CommandRemoveJedi() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the command to remove a Jedi from a specified planet.
     * Expects exactly two arguments after the command: the Jedi's name and the planet's name.
     * If arguments are invalid or exceptions occur during removal, appropriate messages are printed.
     *
     * @param input array of input strings where input[1] is jedi_name and input[2] is planet_name
     */
    @Override
    public void execute(String[] input) {
        try {
            if(input.length != 3) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
            universe.removeJediFromPlanet(input[1], input[2]);
        } catch (PlanetManagementException | JediManagementException e) {
            System.out.println(e.getMessage());
        }
    }
}
