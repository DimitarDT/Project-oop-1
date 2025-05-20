package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;


/**
 * Command to promote a Jedi by a specified multiplier.
 * Usage: promote_jedi jedi_name multiplier
 */
public class CommandPromoteJedi implements Command {
    private final StarWarsUniverse universe;

    public CommandPromoteJedi() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the promotion of a Jedi.
     * @param input expects exactly 3 elements: ["promote_jedi", jedi_name, multiplier]
     */
    @Override
    public void execute(String[] input) {
        try {
            if(input.length != 3) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
            universe.promote(input[1], Double.parseDouble(input[2]));
        } catch (JediManagementException e) {
            System.out.println(e.getMessage());
        }
    }
}
