package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.*;
import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;

/**
 * Command to create a Jedi on a specified planet.
 * Supports Jedi names with one or two words (the latter must be wrapped in quotes).
 * Usage:
 *  create_jedi planet_name jedi_name jedi_rank jedi_age saber_color jedi_strength
 */
public class CommandCreateJedi implements Command {
    private final StarWarsUniverse universe;

    public CommandCreateJedi() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the create_jedi command.
     * Supports Jedi names as a single word or two words wrapped in quotes.
     *
     * @param input command input tokens
     */
    @Override
    public void execute(String[] input) {
        try {
            if(input.length == 7) {
                universe.createJedi(input[1], input[2], JediRank.valueOf(input[3].toUpperCase()), Integer.parseInt(input[4]), input[5], Double.parseDouble(input[6]));
            }
            else if(input.length == 8) {
                if(!(input[2].startsWith("\"") && input[3].endsWith("\""))) {
                    throw new IllegalArgumentException("Wrong number of arguments.");
                }
                String jediName = input[2] + " " + input[3];
                jediName = jediName.replace("\"", "");
                universe.createJedi(input[1], jediName, JediRank.valueOf(input[4].toUpperCase()), Integer.parseInt(input[5]), input[6], Double.parseDouble(input[7]));
            }
            else {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
        } catch (PlanetManagementException | JediManagementException e) {
            System.out.println(e.getMessage());
        }
    }
}
