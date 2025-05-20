package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * CommandSave implements the Command interface
 * and handles the saving of the current Star Wars universe data.
 */
public class CommandSave implements Command{
    private final StarWarsUniverse universe;

    /**
     * Constructs a new CommandSave instance.
     * It initializes the reference to the singleton StarWarsUniverse.
     */
    public CommandSave() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the save command.
     * This triggers saving the current data to the previously opened file.
     * No additional arguments are required.
     *
     * @param input Command arguments, ignored for this command.
     */
    @Override
    public void execute(String[] input) {
        universe.save();
    }
}
