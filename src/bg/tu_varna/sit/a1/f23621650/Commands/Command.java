package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.UnknownCommandException;

public interface Command {
    void execute(String[] input) throws UnknownCommandException;
}
