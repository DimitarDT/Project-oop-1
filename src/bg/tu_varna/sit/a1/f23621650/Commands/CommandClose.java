package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * Command to close the currently opened file and clear the universe data.
 * Usage: close
 */
public class CommandClose implements Command{
    private final StarWarsUniverse universe;

    public CommandClose() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the close command.
     *
     * @param input command input tokens; expected to be just ["close"].
     */
    @Override
    public void execute(String[] input) {
        universe.close();
    }
}
