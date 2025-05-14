package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

public class CommandDemoteJedi implements Command {
    private final StarWarsUniverse universe;

    public CommandDemoteJedi() {
        this.universe = StarWarsUniverse.getInstance();
    }

    @Override
    public void execute(String[] input) {
        try {
            if(input.length != 3) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
            universe.demote(input[1], Double.parseDouble(input[2]));
        } catch (JediManagementException e) {
            System.out.println(e.getMessage());
        }
    }
}
