package bg.tu_varna.sit.a1.f23621650.Commands;

/**
 * Command that displays the command menu listing all available commands.
 */
public class CommandMenu implements Command {

    /**
     * Executes the menu command by printing the command menu.
     *
     * @param input command arguments (ignored for this command)
     */
    @Override
    public void execute(String[] input) {
        CLI.printMenu();
    }
}
