package bg.tu_varna.sit.a1.f23621650.Commands;

/**
 * Command that displays the help menu with a list of available commands and usage instructions.
 */
public class CommandHelp implements Command {

    /**
     * Executes the help command by printing the help menu.
     *
     * @param input command arguments (ignored for this command)
     */
    @Override
    public void execute(String[] input) {
        CLI.printHelp();
    }
}
