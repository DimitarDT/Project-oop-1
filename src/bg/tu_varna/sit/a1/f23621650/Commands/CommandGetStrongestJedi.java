package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;
import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

public class CommandGetStrongestJedi implements Command {
    private final StarWarsUniverse universe;

    public CommandGetStrongestJedi() {
        this.universe = StarWarsUniverse.getInstance();
    }

    @Override
    public void execute(String[] input) {
        try {
            if(input.length != 2) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
            universe.getStrongestJedi(input[1]);
        } catch (PlanetManagementException | JediManagementException e) {
            System.out.println(e.getMessage());
        }
    }
}
