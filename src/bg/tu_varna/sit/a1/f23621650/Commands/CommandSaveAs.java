package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * CommandSaveAs implements the Command interface
 * and handles saving the current Star Wars universe data
 * to a specified file.
 */
public class CommandSaveAs implements Command {
    private final StarWarsUniverse universe;

    /**
     * Constructs a new CommandSaveAs instance.
     * Initializes the reference to the singleton StarWarsUniverse.
     */
    public CommandSaveAs() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the saveAs command.
     * Saves the current universe data to a new file specified by the user.
     *
     * @param input Command arguments where input[1] is the filename.
     * @throws IllegalArgumentException if the number of arguments is incorrect.
     */
    @Override
    public void execute(String[] input) {
        if(input.length != 2) {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }
        universe.saveAs(input[1]);
    }
}
