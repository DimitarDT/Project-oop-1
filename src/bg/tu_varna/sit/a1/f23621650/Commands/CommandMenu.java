package bg.tu_varna.sit.a1.f23621650.Commands;

public class CommandMenu implements Command {
    @Override
    public void execute(String[] input) {
        CLI.printMenu();
    }
}
