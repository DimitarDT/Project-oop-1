package bg.tu_varna.sit.a1.f23621650.Commands;

public class CommandHelp implements Command {
    @Override
    public void execute(String[] input) {
        CLI.printHelp();
    }
}
