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
            System.out.println("Jedi / Planet");
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            if(command.equalsIgnoreCase("Jedi")) {
                try {
                    universe.printJedi(input[1]);
                } catch (JediManagementException e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equalsIgnoreCase("Planet")) {
                try {
                    universe.printPlanet(input[1]);
                } catch (PlanetManagementException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                throw new UnknownCommandException("Unavailable choice.");
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
