package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.UnknownCommandException;


/**
 * Represents a command in the command pattern.
 * Each concrete command class will implement this interface
 * and define its own execution logic based on the input arguments.
 */
public interface Command {

    /**
     * Executes the command with the given input arguments.
     *
     * @param input the array of input strings representing command name and parameters
     * @throws UnknownCommandException if the command is unknown or input is invalid
     */
    void execute(String[] input) throws UnknownCommandException;
}
