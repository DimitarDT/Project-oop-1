package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.*;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.UnknownCommandException;

import java.util.Scanner;

public class CommandPrint implements Command {
    private final StarWarsUniverse universe;

    public CommandPrint() {
        this.universe = StarWarsUniverse.getInstance();
    }

    @Override
    public void execute(String[] input) throws UnknownCommandException {
        if(input.length == 2) {
            try {
                universe.printJedi(input[1]);
            } catch (JediManagementException e) {
                try {
                    universe.printPlanet(input[1]);
                } catch (PlanetManagementException ex) {
                    System.out.println("There are no planets or jedis with this name.");
                }
            }
        }
        else if(input.length == 3) {
            if(!(input[1].startsWith("\"") && input[2].endsWith("\""))) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }
            String planetName = input[1] + " " + input[2];
            planetName = planetName.replace("\"", "");
            try {
                universe.printJedi(planetName);
            } catch (JediManagementException e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }
    }
}
